package edu.utdallas.emse.hw1.rental.xbox;

import edu.utdallas.emse.hw1.item.XBox;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;

import java.time.Instant;

public class XBoxRental extends Rental {

    public XBoxRental(XBox xbox, int daysRented, Instant rentalDate) {
        super(xbox, daysRented, rentalDate);
    }

    protected PriceStrategy getPriceStrategy() {
        return XBoxStrategyFactory.getInstance().getPriceStrategy(this);
    }

    protected FRPStrategy getFRPStrategy() {
        return XBoxStrategyFactory.getInstance().getFRPStrategy(this);
    }

    public XBox getXBox() {
        return (XBox) getItem();
    }
}
