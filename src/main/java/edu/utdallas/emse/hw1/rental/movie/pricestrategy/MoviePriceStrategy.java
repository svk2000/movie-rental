package edu.utdallas.emse.hw1.rental.movie.pricestrategy;

import edu.utdallas.emse.hw1.rental.movie.MovieRental;

public interface MoviePriceStrategy {
    double getPrice(MovieRental rental);
}
