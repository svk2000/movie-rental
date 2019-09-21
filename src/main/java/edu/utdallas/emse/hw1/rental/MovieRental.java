package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.core.Movie;
import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

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

    @Serialized(tag = "days-rented")
    private int daysRented;

    @Serialized(tag = "total-price")
    private double totalPrice;

    @Serialized(tag = "frequent-renter-points")
    private int frequentRenterPoints;

    //Exception Checks
    MovieRental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
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

    protected double calculatePrice() {
        Movie.Category cat = movie.getCategory();
        int diffDaysRented = getDaysRented() - getRentalPeriod(cat);
        return getPriceCode(cat) +
                ((diffDaysRented > 0) ? diffDaysRented * 1.5 : 0);
    }

    //TODO remove this
    protected int calculateFrequentRenterPoints() {
        return 1;
    }

    private double getPriceCode(Movie.Category c) {
        Double pc = PRICE_CODE.get(c);
        return pc == null ? 2.0 : pc;
    }

    private int getRentalPeriod(Movie.Category c) {
        Integer rp = RENTAL_PERIOD.get(c);
        return rp == null ? 2 : rp;
    }
}
