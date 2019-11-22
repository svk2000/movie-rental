package edu.utdallas.emse.hw1.rental.videogame;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.videogame.points.DefaultVideoGameFRPStrategy;
import edu.utdallas.emse.hw1.rental.videogame.price.DefaultVideoGamePriceStrategy;

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

    public PriceStrategy getPriceStrategy(VideoGameRental rental) {
        return DefaultVideoGamePriceStrategy.getInstance();
    }

    public FRPStrategy getFRPStrategy(VideoGameRental rental) {
        return DefaultVideoGameFRPStrategy.getInstance();
    }
}
