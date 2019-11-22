package edu.utdallas.emse.hw1.rental.movie.points;

import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.FRPStrategy;

public class DefaultMovieFRPStrategy implements FRPStrategy {
    private static final DefaultMovieFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMovieFRPStrategy();
    }

    private DefaultMovieFRPStrategy() {
    }

    public static DefaultMovieFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        return 1;
    }
}
