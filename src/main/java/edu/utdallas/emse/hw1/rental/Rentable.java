package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.transaction.TransactionItem;

public interface Rentable extends TransactionItem {
    default double getPrice() {
        return getRentalPrice();
    }

    double getRentalPrice();

    int getFrequentRenterPoints();
}