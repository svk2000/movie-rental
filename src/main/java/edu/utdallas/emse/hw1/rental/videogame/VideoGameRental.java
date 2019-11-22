package edu.utdallas.emse.hw1.rental.videogame;

import edu.utdallas.emse.hw1.item.VideoGame;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

public class VideoGameRental extends Rental {
    @Serialized(tag = "is-new-release")
    private final boolean isNewRelease;

    public VideoGameRental(VideoGame videoGame, int daysRented, Instant rentalDate) {
        super(videoGame, daysRented, rentalDate);
        this.isNewRelease = (getDate().getEpochSecond() - videoGame.getReleaseDate().getEpochSecond())
                < 2629800L;
    }

    protected PriceStrategy getPriceStrategy() {
        return VideoGameStrategyFactory.getInstance().getPriceStrategy(this);
    }

    protected FRPStrategy getFRPStrategy() {
        return VideoGameStrategyFactory.getInstance().getFRPStrategy(this);
    }

    public boolean isNewRelease() {
        return this.isNewRelease;
    }

    public VideoGame getVideoGame() {
        return (VideoGame) getItem();
    }
}
