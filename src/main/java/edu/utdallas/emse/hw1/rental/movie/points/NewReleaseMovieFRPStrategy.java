package edu.utdallas.emse.hw1.rental.movie.points;

import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.FRPStrategy;

public class NewReleaseMovieFRPStrategy implements FRPStrategy {
    private static final NewReleaseMovieFRPStrategy INSTANCE;

    static {
        INSTANCE = new NewReleaseMovieFRPStrategy();
    }

    private NewReleaseMovieFRPStrategy() {
    }

    public static NewReleaseMovieFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        int bonusPts = rental.getDaysRented() > 1 ? 1 : 0;
        return bonusPts + 1;
    }
}
