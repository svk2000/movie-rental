package edu.utdallas.emse.hw1.rental.pricestrategy;

import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.rental.MovieRental;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultMoviePriceStrategy implements MoviePriceStrategy {
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

    @Override
    public double getPrice(MovieRental rental) {
        Movie.Category cat = rental.getMovie().getCategory();
        int diffDaysRented = rental.getDaysRented() - getRentalPeriod(cat);
        return getPriceCode(cat) +
                ((diffDaysRented > 0) ? diffDaysRented * 1.5 : 0);
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
