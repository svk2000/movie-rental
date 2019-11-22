package edu.utdallas.emse.hw1.transaction;

import edu.utdallas.emse.hw1.item.Item;

import java.time.Instant;

public interface TransactionItem {
    double getPrice();

    Instant getDate();

    Item getItem();
}
