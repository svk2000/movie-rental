package edu.utdallas.emse.hw1.purchase.xbox.points;

import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;

public class DefaultXBoxRewardsPointStrategy implements RewardsPointStrategy {
    private static final DefaultXBoxRewardsPointStrategy INSTANCE;

    static {
        INSTANCE = new DefaultXBoxRewardsPointStrategy();
    }

    private DefaultXBoxRewardsPointStrategy() {
    }

    public static DefaultXBoxRewardsPointStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getRewardsPoints(Purchase purchase) {
        return 4;
    }
}
