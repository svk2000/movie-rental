package edu.utdallas.emse.hw1.rental.playstation.points;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

public class DefaultPlayStationFRPStrategy implements FRPStrategy {
    private static final DefaultPlayStationFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultPlayStationFRPStrategy();
    }

    private DefaultPlayStationFRPStrategy() {
    }

    public static DefaultPlayStationFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        return 3;
    }
}
