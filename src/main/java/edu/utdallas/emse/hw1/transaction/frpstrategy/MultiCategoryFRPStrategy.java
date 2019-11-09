package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.rental.Rentable;
import edu.utdallas.emse.hw1.transaction.Transaction;

import java.util.List;

public class MultiCategoryFRPStrategy implements TransactionFRPStrategy {
    private static final MultiCategoryFRPStrategy INSTANCE;

    static {
        INSTANCE = new MultiCategoryFRPStrategy();
    }

    private MultiCategoryFRPStrategy() {
    }

    public static MultiCategoryFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Transaction t) {
        List<Rentable> rentals = t.getRentals();
        int firstFRP = rentals.get(0).getFrequentRenterPoints();

        return firstFRP +
                rentals.stream()
                        .map(rental -> rental.getFrequentRenterPoints())
                        .reduce(0, (a, b) -> a + b);
    }
}
