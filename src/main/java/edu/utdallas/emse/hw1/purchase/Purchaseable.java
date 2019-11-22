package edu.utdallas.emse.hw1.purchase;

import edu.utdallas.emse.hw1.transaction.TransactionItem;

public interface Purchaseable extends TransactionItem {

    default double getPrice() {
        return getPurchasePrice();
    }

    double getPurchasePrice();

    int getRewardsPoints();
}
