package edu.utdallas.emse.hw1.purchase.playstation.price;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;

public class DefaultPlayStationPriceStrategy implements PriceStrategy {

    private static final DefaultPlayStationPriceStrategy INSTANCE;

    static {
        INSTANCE = new DefaultPlayStationPriceStrategy();
    }

    private DefaultPlayStationPriceStrategy() {
    }

    public static DefaultPlayStationPriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return 315.0;
    }
}
