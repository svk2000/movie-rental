package edu.utdallas.emse.hw1.rental.xbox;

import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.xbox.points.DefaultXBoxFRPStrategy;
import edu.utdallas.emse.hw1.rental.xbox.price.DefaultXBoxPriceStrategy;

public class XBoxStrategyFactory {
    private static final XBoxStrategyFactory INSTANCE;

    static {
        INSTANCE = new XBoxStrategyFactory();
    }

    private XBoxStrategyFactory() {
    }

    public static XBoxStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(XBoxRental rental) {
        return DefaultXBoxPriceStrategy.getInstance();
    }

    public FRPStrategy getFRPStrategy(XBoxRental rental) {
        return DefaultXBoxFRPStrategy.getInstance();
    }
}
