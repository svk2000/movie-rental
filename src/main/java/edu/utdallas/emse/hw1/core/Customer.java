package edu.utdallas.emse.hw1.core;

import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.util.List;
import java.util.ArrayList;

@Serialized
public class Customer implements ObjectSerializable {
    @Serialized
    private String name;

    @Serialized
    private List<Rental> rentals = new ArrayList<>();

    @Serialized(tag="amount-owed")
    private double totalAmountOwed = 0.0;

    @Serialized(tag="frequent-renter-points")
    private int frequentRenterPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental r) {
        rentals.add(r);
        totalAmountOwed += r.getPrice();
        frequentRenterPoints += r.getFrequentRenterPoints();
    }

    public String getName() {
        return name;
    }

    public double getTotalAmountOwed() {
        return totalAmountOwed;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        rentals.forEach(rental -> {
            // show figures for this rental
            result.append("\t").append(rental.toString()).append("\n");
        });

        // add footer lines
        result.append("Amount owed is ").append(getTotalAmountOwed()).append("\n")
                .append("You earned ").append(getFrequentRenterPoints()).append(" frequent renter points");

        return result.toString();
    }
}
