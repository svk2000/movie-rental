package edu.utdallas.emse.hw1.purchase.movie;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.movie.points.DefaultMovieRewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.movie.price.DefaultMoviePriceStrategy;

public class MovieStrategyFactory {
    private static final MovieStrategyFactory INSTANCE;

    static {
        INSTANCE = new MovieStrategyFactory();
    }

    private MovieStrategyFactory() {
    }

    public static MovieStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(MoviePurchase purchase) {
        return DefaultMoviePriceStrategy.getInstance();
    }

    public RewardsPointStrategy getFRPStrategy(MoviePurchase purchase) {
        return DefaultMovieRewardsPointStrategy.getInstance();
    }
}
