package edu.utdallas.emse.hw1.purchase.playstation;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.playstation.points.DefaultPlayStationRewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.playstation.price.DefaultPlayStationPriceStrategy;

public class PlayStationStrategyFactory {
    private static final PlayStationStrategyFactory INSTANCE;

    static {
        INSTANCE = new PlayStationStrategyFactory();
    }

    private PlayStationStrategyFactory() {
    }

    public static PlayStationStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(PlayStationPurchase purchase) {
        return DefaultPlayStationPriceStrategy.getInstance();
    }

    public RewardsPointStrategy getRewardsPointStrategy(PlayStationPurchase purchase) {
        return DefaultPlayStationRewardsPointStrategy.getInstance();
    }
}
