package edu.utdallas.emse.hw1.rental.musiccd.points;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

public class DefaultMusicCDFRPStrategy implements FRPStrategy {
    private static final DefaultMusicCDFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMusicCDFRPStrategy();
    }

    private DefaultMusicCDFRPStrategy() {
    }

    public static DefaultMusicCDFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Rental rental) {
        return 0;
    }
}
