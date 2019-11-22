package edu.utdallas.emse.hw1.rental.musiccd.price;

import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

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
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * 0.5;
    }
}
