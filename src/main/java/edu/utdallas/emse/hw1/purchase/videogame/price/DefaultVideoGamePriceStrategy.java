package edu.utdallas.emse.hw1.purchase.videogame.price;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;

public class DefaultVideoGamePriceStrategy implements PriceStrategy {

    private static final DefaultVideoGamePriceStrategy INSTANCE;

    static {
        INSTANCE = new DefaultVideoGamePriceStrategy();
    }

    private DefaultVideoGamePriceStrategy() {
    }

    public static DefaultVideoGamePriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return 22.0;
    }
}
