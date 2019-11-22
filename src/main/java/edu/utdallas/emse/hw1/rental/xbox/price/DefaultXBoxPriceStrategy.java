package edu.utdallas.emse.hw1.rental.xbox.price;

import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

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
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * 7;
    }
}
