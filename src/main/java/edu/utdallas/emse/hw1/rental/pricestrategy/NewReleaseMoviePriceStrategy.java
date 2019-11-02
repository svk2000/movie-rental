package edu.utdallas.emse.hw1.rental.pricestrategy;

import edu.utdallas.emse.hw1.rental.MovieRental;

public class NewReleaseMoviePriceStrategy implements MoviePriceStrategy {
    @Override
    public double getPrice(MovieRental rental) {
        return rental.getDaysRented() * 3.0;
    }
}
