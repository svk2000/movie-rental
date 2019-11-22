package edu.utdallas.emse.hw1.rental.xbox.points;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

public class DefaultXBoxFRPStrategy implements FRPStrategy {
    private static final DefaultXBoxFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultXBoxFRPStrategy();
    }

    private DefaultXBoxFRPStrategy() {
    }

    public static DefaultXBoxFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        return 3;
    }
}
