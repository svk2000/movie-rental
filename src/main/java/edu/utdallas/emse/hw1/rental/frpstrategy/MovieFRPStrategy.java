package edu.utdallas.emse.hw1.rental.frpstrategy;

import edu.utdallas.emse.hw1.rental.MovieRental;

public interface MovieFRPStrategy {
    default int getFrequentRentalPoints(MovieRental rental) {
        return 1;
    }
}
