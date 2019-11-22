package edu.utdallas.emse.hw1.rental.musiccd;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.musiccd.points.DefaultMusicCDFRPStrategy;
import edu.utdallas.emse.hw1.rental.musiccd.price.DefaultMusicCDPriceStrategy;

public class MusicCDStrategyFactory {
    private static final MusicCDStrategyFactory INSTANCE;

    static {
        INSTANCE = new MusicCDStrategyFactory();
    }

    private MusicCDStrategyFactory() {
    }

    public static MusicCDStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(MusicCDRental rental) {
        return DefaultMusicCDPriceStrategy.getInstance();
    }

    public FRPStrategy getFRPStrategy(MusicCDRental rental) {
        return DefaultMusicCDFRPStrategy.getInstance();
    }
}
