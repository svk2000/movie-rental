package edu.utdallas.emse.hw1.rental.movie.frpstrategy;

import edu.utdallas.emse.hw1.rental.movie.MovieRental;

public interface MovieFRPStrategy {
    default int getFrequentRentalPoints(MovieRental rental) {
        return 1;
    }
}
