package edu.utdallas.emse.hw1.purchase.movie.price;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;

public class DefaultMoviePriceStrategy implements PriceStrategy {

    private static final DefaultMoviePriceStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMoviePriceStrategy();
    }

    private DefaultMoviePriceStrategy() {
    }

    public static DefaultMoviePriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return 12.3;
    }
}
