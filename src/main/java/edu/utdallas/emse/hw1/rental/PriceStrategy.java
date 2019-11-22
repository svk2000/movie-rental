package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.rental.Rental;

public interface PriceStrategy {
    double getPrice(Rental rental);
}
