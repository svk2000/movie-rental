package edu.utdallas.emse.hw1.rental.videogame.price;

import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

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
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * 1.5;
    }
}
