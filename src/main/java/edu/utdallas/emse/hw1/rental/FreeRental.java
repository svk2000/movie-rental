package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.item.Item;

import java.time.Instant;

public class FreeRental implements Rentable {
    protected final Rentable rental;

    public FreeRental(Rentable r) {
        this.rental = r;
    }

    public Rentable getRental() {
        return rental;
    }

    @Override
    public Item getItem() {
        return rental.getItem();
    }

    @Override
    public double getPrice() {
        return getRentalPrice();
    }

    @Override
    public double getRentalPrice() {
        return 0.0;
    }

    @Override
    public int getFrequentRenterPoints() {
        return 0;
    }

    @Override
    public int getDaysRented() {
        return rental.getDaysRented();
    }

    @Override
    public Instant getDate() {
        return rental.getDate();
    }

    @Override
    public boolean isNewRelease() {
        return rental.isNewRelease();
    }

    @Override
    public String toString() {
        return rental.toString() + "\tFREE";
    }
}
