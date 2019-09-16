package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.core.Movie;
import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@Serialized(tag="movie-rental")
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

    @Serialized(tag="days-rented")
    private int daysRented;

    private Instant rentalDate;
    private boolean isNewRelease;

    @Serialized(tag="total-price")
    private double totalPrice;

    @Serialized(tag="frequent-renter-points")
    private int frequentRenterPoints;

    //Exception Checks
    public MovieRental(Movie movie, int daysRented, Instant rentalDate) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.rentalDate = rentalDate;

        /* New release if rented within 2 months of movie release */
        this.isNewRelease = (rentalDate.getEpochSecond() - movie.getReleaseDate().getEpochSecond())
                < 5259600L;

        this.totalPrice = calculatePrice();
        this.frequentRenterPoints = calculateFrequentRenterPoints();
    }

    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public double getPrice() {
        return totalPrice;
    }

    @Override
    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public Movie getMovie() {
        return movie;
    }

    public Instant getRentalDate() {
        return rentalDate;
    }

    public boolean isNewRelease() {
        return isNewRelease;
    }

    @Override
    public String toString() {
        return String.format("%s\t%.2f", getMovie().toString(), getPrice());
    }

    private double calculatePrice() {
        if (isNewRelease) {
            return daysRented * 3;
        }

		Movie.Category cat = movie.getCategory();
		int diffDaysRented = daysRented - getRentalPeriod(cat);
		return getPriceCode(cat) +
				((diffDaysRented > 0) ? diffDaysRented * 1.5 : 0);
    }

    private int calculateFrequentRenterPoints() {
        int bonusPts = (isNewRelease && daysRented > 1) ? 1 : 0;
        return 1 + bonusPts;
    }

    private double getPriceCode(Movie.Category c) {
        Double pc = PRICE_CODE.get(c);
        return pc == null ? 2 : pc;
    }

    private int getRentalPeriod(Movie.Category c) {
        Integer rp = RENTAL_PERIOD.get(c);
        return rp == null ? 2 : rp;
    }
}
