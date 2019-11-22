package edu.utdallas.emse.hw1.rental.playstation;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.playstation.points.DefaultPlayStationFRPStrategy;
import edu.utdallas.emse.hw1.rental.playstation.price.DefaultPlayStationPriceStrategy;

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

    public PriceStrategy getPriceStrategy(PlayStationRental rental) {
        return DefaultPlayStationPriceStrategy.getInstance();
    }

    public FRPStrategy getFRPStrategy(PlayStationRental rental) {
        return DefaultPlayStationFRPStrategy.getInstance();
    }
}
