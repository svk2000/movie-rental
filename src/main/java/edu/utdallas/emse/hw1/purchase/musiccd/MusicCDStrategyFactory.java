package edu.utdallas.emse.hw1.purchase.musiccd;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.musiccd.points.DefaultMusicCDRewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.musiccd.price.DefaultMusicCDPriceStrategy;

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

    public PriceStrategy getPriceStrategy(MusicCDPurchase purchase) {
        return DefaultMusicCDPriceStrategy.getInstance();
    }

    public RewardsPointStrategy getRewardsPointStrategy(MusicCDPurchase purchase) {
        return DefaultMusicCDRewardsPointStrategy.getInstance();
    }
}
