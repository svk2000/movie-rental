package edu.utdallas.emse.hw1.rental.playstation;

import edu.utdallas.emse.hw1.item.PlayStation;
import edu.utdallas.emse.hw1.item.VideoGame;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.videogame.VideoGameStrategyFactory;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

public class PlayStationRental extends Rental {

    public PlayStationRental(PlayStation playStation, int daysRented, Instant rentalDate) {
        super(playStation, daysRented, rentalDate);
    }

    protected PriceStrategy getPriceStrategy() {
        return PlayStationStrategyFactory.getInstance().getPriceStrategy(this);
    }

    protected FRPStrategy getFRPStrategy() {
        return PlayStationStrategyFactory.getInstance().getFRPStrategy(this);
    }

    public PlayStation getPlayStation() {
        return (PlayStation) getItem();
    }
}
