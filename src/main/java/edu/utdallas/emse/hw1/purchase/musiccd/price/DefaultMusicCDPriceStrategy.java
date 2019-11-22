package edu.utdallas.emse.hw1.purchase.musiccd.price;

import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;

public class DefaultMusicCDPriceStrategy implements PriceStrategy {

    private static final DefaultMusicCDPriceStrategy INSTANCE;

    static {
        INSTANCE = new DefaultMusicCDPriceStrategy();
    }

    private DefaultMusicCDPriceStrategy() {
    }

    public static DefaultMusicCDPriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Purchase purchase) {
        return 6.45;
    }
}
