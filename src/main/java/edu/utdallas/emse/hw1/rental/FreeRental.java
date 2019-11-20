package edu.utdallas.emse.hw1.rental;

public class FreeRental implements Rentable {
    private final Rentable rental;

    public FreeRental(Rentable r) {
        this.rental = r;
    }

    public Rentable getBaseRental() {
        return this.rental;
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
    public String toString() {
        return rental.toString() + "\tFREE";
    }
}
