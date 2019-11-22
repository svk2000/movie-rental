package edu.utdallas.emse.hw1.purchase.musiccd.points;

import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;

public class DefaultMusicCDRewardsPointStrategy implements RewardsPointStrategy {
    private static final DefaultMusicCDRewardsPointStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMusicCDRewardsPointStrategy();
    }

    private DefaultMusicCDRewardsPointStrategy() {
    }

    public static DefaultMusicCDRewardsPointStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getRewardsPoints(Purchase purchase) {
        return 1;
    }
}
