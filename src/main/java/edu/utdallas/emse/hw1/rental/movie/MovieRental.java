package edu.utdallas.emse.hw1.rental.movie;

import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.rental.Rentable;
import edu.utdallas.emse.hw1.rental.movie.frpstrategy.DefaultMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.movie.frpstrategy.MovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.movie.frpstrategy.NewReleaseMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.movie.pricestrategy.DefaultMoviePriceStrategy;
import edu.utdallas.emse.hw1.rental.movie.pricestrategy.MoviePriceStrategy;
import edu.utdallas.emse.hw1.rental.movie.pricestrategy.NewReleaseMoviePriceStrategy;
import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "movie-rental")
public class MovieRental implements Rentable, ObjectSerializable {
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
    public double getRentalPrice() {
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
        return String.format("%s\t%.2f", getMovie().toString(), getRentalPrice());
    }

    private double calculatePrice() {
        return mpStrategy.getPrice(this);
    }

    private int calculateFrequentRenterPoints() {
        return frpStrategy.getFrequentRentalPoints(this);
    }
}
