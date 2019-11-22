package edu.utdallas.emse.hw1.purchase.movie.points;

import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;

public class DefaultMovieRewardsPointStrategy implements RewardsPointStrategy {
    private static final DefaultMovieRewardsPointStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMovieRewardsPointStrategy();
    }

    private DefaultMovieRewardsPointStrategy() {
    }

    public static DefaultMovieRewardsPointStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getRewardsPoints(Purchase purchase) {
        return 2;
    }
}
