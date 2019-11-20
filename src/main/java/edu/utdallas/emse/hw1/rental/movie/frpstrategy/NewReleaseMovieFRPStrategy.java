package edu.utdallas.emse.hw1.rental.movie.frpstrategy;

import edu.utdallas.emse.hw1.rental.movie.MovieRental;

public class NewReleaseMovieFRPStrategy implements MovieFRPStrategy {
    @Override
    public int getFrequentRentalPoints(MovieRental rental) {
        int bonusPts = (rental.isNewRelease() && rental.getDaysRented() > 1) ? 1 : 0;
        return bonusPts + MovieFRPStrategy.super.getFrequentRentalPoints(rental);
    }
}
