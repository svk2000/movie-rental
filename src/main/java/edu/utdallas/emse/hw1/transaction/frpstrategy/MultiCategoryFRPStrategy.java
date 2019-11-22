package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.transaction.Transaction;

import java.util.ArrayList;
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
        List<Rental> rentals = new ArrayList();

        t.getItems().forEach(item -> {
            if (item instanceof Rental) {
                rentals.add((Rental) item);
            }
        });

        int firstFRP = (rentals.get(0)).getFrequentRenterPoints();

        return firstFRP +
                rentals.stream()
                        .map(rental -> rental.getFrequentRenterPoints())
                        .reduce(0, (a, b) -> a + b);
    }
}
