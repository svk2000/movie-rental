package edu.utdallas.emse.hw1.transaction;

import edu.utdallas.emse.hw1.Customer;
import edu.utdallas.emse.hw1.purchase.Purchaseable;
import edu.utdallas.emse.hw1.rental.FreeRental;
import edu.utdallas.emse.hw1.rental.Rentable;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.Serialized;
import edu.utdallas.emse.hw1.transaction.frpstrategy.TransactionFRPStrategy;
import edu.utdallas.emse.hw1.transaction.frpstrategy.TransactionFRPStrategyFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Serialized(tag = "transaction")
public class Transaction {
    @Serialized(tag = "total-cost")
    private double totalCost;

    @Serialized(tag = "rewards-points")
    private int rewardsPoints;

    @Serialized(tag = "frequent-renter-points")
    private int frequentRenterPoints;

    @Serialized
    private List<TransactionItem> items = new ArrayList<>();

    private TransactionFRPStrategy tfrpStrategy;

    public Transaction(Customer c, List<TransactionItem> ti) {
        this.items.addAll(
                ti.stream()
                        .sorted(Comparator.comparing(TransactionItem::getPrice))
                        .collect(Collectors.toList()));

        /* Determine free rentals and deduct frequent renter points */
        processFreeRentals(c);

        /* Calculate this transactions cost and frequent rental points */
        this.tfrpStrategy = TransactionFRPStrategyFactory.getStrategy(c, items);
        totalCost = calcTotalCost();
        rewardsPoints = calcTotalRewardsPoints();
        frequentRenterPoints = calcTotalFrequentRenterPoints();

        /* Apply this transaction to the customer */
        c.addToBalance(totalCost);
        c.addToRewardsPoints(rewardsPoints);
        c.addToFrequentRenterPoints(frequentRenterPoints);
        c.addTransaction(this);
    }

    public List<TransactionItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tTRANSACTION\n");
        sb.append("\t\tRentals:\n");
        items.stream().filter(item -> item instanceof Rentable)
                .forEach(item -> sb.append("\t\t\t").append(item.toString()).append("\n"));

        sb.append("\t\tPurchases:\n");
        items.stream().filter(item -> item instanceof Purchaseable)
                .forEach(item -> sb.append("\t\t\t").append(item.toString()).append("\n"));

        sb.append("\t\tTransaction price: ").append(totalCost).append("\n")
                .append("\t\tTransaction Rewards Points: ").append(rewardsPoints).append("\n")
                .append("\t\tTransaction Renter Points: ").append(frequentRenterPoints).append("\n");

        return sb.toString();
    }

    private double calcTotalCost() {
        return items.stream()
                .map(item -> item.getPrice())
                .reduce(0.0, (a, b) -> a + b);
    }

    private int calcTotalRewardsPoints() {
        return items.stream()
                .filter(item -> item instanceof Purchaseable)
                .map(item -> ((Purchaseable) item).getRewardsPoints())
                .reduce(0, (a, b) -> a + b);
    }

    private int calcTotalFrequentRenterPoints() {
        return tfrpStrategy.getFrequentRentalPoints(this);
    }

    private void processFreeRentals(Customer c) {
        List<FreeRental> freeRentals = new ArrayList();

        int numFreeRentals = c.getFrequentRenterPoints() / 10;
        for (int i = 0; numFreeRentals > 0 && i < items.size(); i++) {
            TransactionItem ti = items.get(i);
            if (ti instanceof Rentable) {
                freeRentals.add(new FreeRental((Rental) ti));
                numFreeRentals--;
            }
        }

        freeRentals.forEach(rental -> {
            items.remove(rental.getRental());
            items.add(rental);
        });

        c.deductFrequentRenterPoints(freeRentals.size() * 10);
    }
}
