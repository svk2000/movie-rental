package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.rental.frpstrategy.DefaultMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.frpstrategy.MovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.frpstrategy.NewReleaseMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.pricestrategy.DefaultMoviePriceStrategy;
import edu.utdallas.emse.hw1.rental.pricestrategy.MoviePriceStrategy;
import edu.utdallas.emse.hw1.rental.pricestrategy.NewReleaseMoviePriceStrategy;
import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@Serialized(tag = "movie-rental")
public class MovieRental implements Rental, ObjectSerializable {
    private static final Map<Movie.Category, Double> PRICE_CODE;
    private static final Map<Movie.Category, Integer> RENTAL_PERIOD;

    static {
        final Map<Movie.Category, Double> tmpPC = new ConcurrentHashMap<>();
        tmpPC.put(Movie.Category.CHILDRENS, 1.5);
        PRICE_CODE = Collections.unmodifiableMap(tmpPC);

        final Map<Movie.Category, Integer> tmpRP = new ConcurrentHashMap<>();
        tmpRP.put(Movie.Category.CHILDRENS, 3);
        RENTAL_PERIOD = Collections.unmodifiableMap(tmpRP);
    }

    @Serialized
    private Movie movie;

    @Serialized(tag = "is-new-release")
    private boolean isNewRelease;

    @Serialized(tag = "days-rented")
    private int daysRented;

    @Serialized(tag = "total-price")
    private double totalPrice;

    @Serialized(tag = "frequent-renter-points")
    private int frequentRenterPoints;

    private MoviePriceStrategy mpStrategy;
    private MovieFRPStrategy frpStrategy;

    //Exception Checks
    public MovieRental(Movie movie, int daysRented, Instant rentalDate) {
        this.movie = movie;
        this.daysRented = daysRented;

        /* New release if rented within 2 months of movie release */
        this.isNewRelease = (rentalDate.getEpochSecond() - movie.getReleaseDate().getEpochSecond())
                < 5259600L;


        mpStrategy = movie.getCategory() == Movie.Category.CHILDRENS || !isNewRelease ?
                new DefaultMoviePriceStrategy() : new NewReleaseMoviePriceStrategy();

        frpStrategy = movie.getCategory() == Movie.Category.CHILDRENS || !isNewRelease ?
                new DefaultMovieFRPStrategy() : new NewReleaseMovieFRPStrategy();
    }

    public int getDaysRented() {
        return daysRented;
    }

    public boolean isNewRelease() {
        return this.isNewRelease;
    }

    @Override
    public double getPrice() {
        if (totalPrice > 0) {
            return totalPrice;
        }

        totalPrice = calculatePrice();
        return totalPrice;
    }

    @Override
    public int getFrequentRenterPoints() {
        if (frequentRenterPoints == 0) {
            frequentRenterPoints = calculateFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return String.format("%s\t%.2f", getMovie().toString(), getPrice());
    }

    private double calculatePrice() {
        return mpStrategy.getPrice(this);
    }

    private int calculateFrequentRenterPoints() {
        return frpStrategy.getFrequentRentalPoints(this);
    }
}
