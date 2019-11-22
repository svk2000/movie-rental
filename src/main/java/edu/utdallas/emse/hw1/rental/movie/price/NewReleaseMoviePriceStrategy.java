package edu.utdallas.emse.hw1.rental.movie.price;

import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.PriceStrategy;

public class NewReleaseMoviePriceStrategy implements PriceStrategy {
    private static final NewReleaseMoviePriceStrategy INSTANCE;

    static {
        INSTANCE = new NewReleaseMoviePriceStrategy();
    }

    private NewReleaseMoviePriceStrategy() {
    }

    public static NewReleaseMoviePriceStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double getPrice(Rental rental) {
        return rental.getDaysRented() * 3.0;
    }
}
