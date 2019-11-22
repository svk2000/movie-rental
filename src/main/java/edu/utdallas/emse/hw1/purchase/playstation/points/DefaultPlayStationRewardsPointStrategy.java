package edu.utdallas.emse.hw1.purchase.playstation.points;

import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;

public class DefaultPlayStationRewardsPointStrategy implements RewardsPointStrategy {
    private static final DefaultPlayStationRewardsPointStrategy INSTANCE;

    static {
        INSTANCE = new DefaultPlayStationRewardsPointStrategy();
    }

    private DefaultPlayStationRewardsPointStrategy() {
    }

    public static DefaultPlayStationRewardsPointStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getRewardsPoints(Purchase purchase) {
        return 4;
    }
}
