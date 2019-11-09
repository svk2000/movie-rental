package edu.utdallas.emse.hw1.rental.frpstrategy;

import edu.utdallas.emse.hw1.rental.MovieRental;

public class NewReleaseMovieFRPStrategy implements MovieFRPStrategy {
    @Override
    public int getFrequentRentalPoints(MovieRental rental) {
        int bonusPts = (rental.isNewRelease() && rental.getDaysRented() > 1) ? 1 : 0;
        return bonusPts + MovieFRPStrategy.super.getFrequentRentalPoints(rental);
    }
}
