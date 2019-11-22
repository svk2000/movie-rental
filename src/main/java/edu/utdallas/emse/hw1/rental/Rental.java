package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.item.Item;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized
public abstract class Rental implements Rentable {
    @Serialized
    private final Item item;

    @Serialized
    private final Instant date;

    @Serialized(tag = "days-rented")
    private final int daysRented;

    @Serialized(tag = "total-price")
    private double totalPrice;

    @Serialized(tag = "frequent-renter-points")
    private int frequentRenterPoints;

    private PriceStrategy priceStrategy;
    private FRPStrategy frpStrategy;

    public Rental(Item rentalItem, int daysRented, Instant rentalDate) {
        this.item = rentalItem;
        this.date = rentalDate;
        this.daysRented = daysRented;
    }

    protected abstract PriceStrategy getPriceStrategy();

    protected abstract FRPStrategy getFRPStrategy();

    @Override
    public Item getItem() {
        return this.item;
    }

    @Override
    public double getRentalPrice() {
        if (totalPrice > 0) {
            return totalPrice;
        }

        totalPrice = calculatePrice();
        return totalPrice;
    }

    private double calculatePrice() {
        if (priceStrategy == null) {
            priceStrategy = getPriceStrategy();
        }

        return priceStrategy.getPrice(this);
    }

    @Override
    public int getFrequentRenterPoints() {
        if (frequentRenterPoints == 0) {
            frequentRenterPoints = calculateFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    private int calculateFrequentRenterPoints() {
        if (frpStrategy == null) {
            frpStrategy = getFRPStrategy();
        }

        return frpStrategy.getFrequentRentalPoints(this);
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public Instant getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("RENTAL: %s\t%.2f", getItem().toString(), getRentalPrice());
    }
}