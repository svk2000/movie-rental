package edu.utdallas.emse.hw1.rental.musiccd;

import edu.utdallas.emse.hw1.item.MusicCD;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

public class MusicCDRental extends Rental {
    @Serialized(tag = "is-new-release")
    private final boolean isNewRelease;

    public MusicCDRental(MusicCD musicCD, int daysRented, Instant rentalDate) {
        super(musicCD, daysRented, rentalDate);
        this.isNewRelease = (getDate().getEpochSecond() - musicCD.getReleaseDate().getEpochSecond())
                < 2629800L;
    }

    protected PriceStrategy getPriceStrategy() {
        return MusicCDStrategyFactory.getInstance().getPriceStrategy(this);
    }

    protected FRPStrategy getFRPStrategy() {
        return MusicCDStrategyFactory.getInstance().getFRPStrategy(this);
    }

    public boolean isNewRelease() {
        return this.isNewRelease;
    }

    public MusicCD getCD() {
        return (MusicCD) getItem();
    }
}
