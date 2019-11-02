package edu.utdallas.emse.hw1.transaction;

import edu.utdallas.emse.hw1.Customer;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.Serialized;
import edu.utdallas.emse.hw1.transaction.frpstrategy.TransactionFRPStrategy;
import edu.utdallas.emse.hw1.transaction.frpstrategy.TransactionFRPStrategyFactory;

import java.util.ArrayList;
import java.util.List;

@Serialized(tag = "transaction")
public class Transaction {
    @Serialized(tag = "total-cost")
    private double totalCost;

    @Serialized(tag = "frequent-renter-points")
    private int frequentRenterPoints;

    @Serialized
    private List<Rental> rentals = new ArrayList<>();

    private TransactionFRPStrategy tfrpStrategy;

    public Transaction(Customer c, List<Rental> rentals) {
        this.rentals.addAll(rentals);
        this.tfrpStrategy = TransactionFRPStrategyFactory.getStrategy(c, rentals);
        totalCost = calcTotalCost();
        frequentRenterPoints = calcTotalFrequentRenterPoints();
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public double getPrice() {
        return totalCost;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        rentals.forEach(rental -> sb.append("\t").append(rental.toString()).append("\n"));
        return sb.toString();
    }

    private double calcTotalCost() {
        return rentals.stream()
                .map(rental -> rental.getPrice())
                .reduce(0.0, (a, b) -> a + b);
    }

    private int calcTotalFrequentRenterPoints() {
        return tfrpStrategy.getFrequentRentalPoints(this);
    }
}
