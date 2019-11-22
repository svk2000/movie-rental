package edu.utdallas.emse.hw1.purchase.videogame;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.videogame.points.DefaultVideoGameRewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.videogame.price.DefaultVideoGamePriceStrategy;

public class VideoGameStrategyFactory {
    private static final VideoGameStrategyFactory INSTANCE;

    static {
        INSTANCE = new VideoGameStrategyFactory();
    }

    private VideoGameStrategyFactory() {
    }

    public static VideoGameStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(VideoGamePurchase purchase) {
        return DefaultVideoGamePriceStrategy.getInstance();
    }

    public RewardsPointStrategy getRewardsPointStrategy(VideoGamePurchase purchase) {
        return DefaultVideoGameRewardsPointStrategy.getInstance();
    }
}
