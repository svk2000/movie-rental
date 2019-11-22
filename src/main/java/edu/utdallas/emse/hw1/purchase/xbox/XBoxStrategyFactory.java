package edu.utdallas.emse.hw1.purchase.xbox;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.xbox.points.DefaultXBoxRewardsPointStrategy;
import edu.utdallas.emse.hw1.purchase.xbox.price.DefaultXBoxPriceStrategy;

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

    public PriceStrategy getPriceStrategy(XBoxPurchase purchase) {
        return DefaultXBoxPriceStrategy.getInstance();
    }

    public RewardsPointStrategy getRewardsPointStrategy(XBoxPurchase purchase) {
        return DefaultXBoxRewardsPointStrategy.getInstance();
    }
}
