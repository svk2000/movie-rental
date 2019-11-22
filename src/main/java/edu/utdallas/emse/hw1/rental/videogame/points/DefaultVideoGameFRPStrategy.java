package edu.utdallas.emse.hw1.rental.videogame.points;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

public class DefaultVideoGameFRPStrategy implements FRPStrategy {
    private static final DefaultVideoGameFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultVideoGameFRPStrategy();
    }

    private DefaultVideoGameFRPStrategy() {
    }

    public static DefaultVideoGameFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        return 2;
    }
}
