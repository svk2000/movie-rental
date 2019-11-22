package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.item.Item;
import edu.utdallas.emse.hw1.transaction.TransactionItem;

import java.time.Instant;

public interface Rentable extends TransactionItem {
    Item getItem();

    default double getPrice() {
        return getRentalPrice();
    }

    double getRentalPrice();

    int getFrequentRenterPoints();

    int getDaysRented();

    Instant getDate();
}
