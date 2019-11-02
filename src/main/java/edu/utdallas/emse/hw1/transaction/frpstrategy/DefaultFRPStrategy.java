package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.transaction.Transaction;

public class DefaultFRPStrategy implements TransactionFRPStrategy {
    private static final DefaultFRPStrategy INSTANCE;

    static {
        INSTANCE = new DefaultFRPStrategy();
    }

    private DefaultFRPStrategy() {
    }

    public static DefaultFRPStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public int getFrequentRentalPoints(Transaction t) {
        return t.getRentals().stream()
                .map(rental -> rental.getFrequentRenterPoints())
                .reduce(0, (a, b) -> a + b);
    }
}
