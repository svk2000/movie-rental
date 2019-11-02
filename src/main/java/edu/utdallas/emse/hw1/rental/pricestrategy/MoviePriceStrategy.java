package edu.utdallas.emse.hw1.rental.pricestrategy;

import edu.utdallas.emse.hw1.rental.MovieRental;

public interface MoviePriceStrategy {
    double getPrice(MovieRental rental);
}
