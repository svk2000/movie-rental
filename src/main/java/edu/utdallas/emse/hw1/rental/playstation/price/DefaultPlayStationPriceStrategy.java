package edu.utdallas.emse.hw1.rental.playstation.price;

import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.playstation.PlayStationRental;

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
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * 7;
    }
}
