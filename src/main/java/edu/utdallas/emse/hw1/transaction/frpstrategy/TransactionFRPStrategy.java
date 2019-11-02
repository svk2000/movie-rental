package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.transaction.Transaction;

public interface TransactionFRPStrategy {
    int getFrequentRentalPoints(Transaction t);
}
