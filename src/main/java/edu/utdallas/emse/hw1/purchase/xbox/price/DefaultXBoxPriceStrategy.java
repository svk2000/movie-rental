package edu.utdallas.emse.hw1.purchase.xbox.price;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;

public class DefaultXBoxPriceStrategy implements PriceStrategy {

    private static final DefaultXBoxPriceStrategy INSTANCE;

    static {
        INSTANCE = new DefaultXBoxPriceStrategy();
    }

    private DefaultXBoxPriceStrategy() {
    }

    public static DefaultXBoxPriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return 400.0;
    }
}
