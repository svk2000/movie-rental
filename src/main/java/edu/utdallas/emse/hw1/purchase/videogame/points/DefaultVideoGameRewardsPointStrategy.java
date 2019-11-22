package edu.utdallas.emse.hw1.purchase.videogame.points;

import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;

public class DefaultVideoGameRewardsPointStrategy implements RewardsPointStrategy {
    private static final DefaultVideoGameRewardsPointStrategy INSTANCE;

    static {
        INSTANCE = new DefaultVideoGameRewardsPointStrategy();
    }

    private DefaultVideoGameRewardsPointStrategy() {
    }

    public static DefaultVideoGameRewardsPointStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getRewardsPoints(Purchase purchase) {
        return 2;
    }
}
