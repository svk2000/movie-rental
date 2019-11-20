package edu.utdallas.emse.hw1.rental.movie.pricestrategy;

import edu.utdallas.emse.hw1.rental.movie.MovieRental;

public class NewReleaseMoviePriceStrategy implements MoviePriceStrategy {
    @Override
    public double getPrice(MovieRental rental) {
        return rental.getDaysRented() * 3.0;
    }
}
