package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.item.*;
import edu.utdallas.emse.hw1.rental.movie.MovieRental;
import edu.utdallas.emse.hw1.rental.musiccd.MusicCDRental;
import edu.utdallas.emse.hw1.rental.playstation.PlayStationRental;
import edu.utdallas.emse.hw1.rental.videogame.VideoGameRental;
import edu.utdallas.emse.hw1.rental.xbox.XBoxRental;

import java.time.Instant;

public class RentalFactory {

    public static Rental getRental(Item item, int daysRented){
        Rental rental = null;
        Instant transactionTime = Instant.now();

        if (item instanceof Movie) {
            rental = new MovieRental((Movie)item, daysRented, transactionTime);
        } else if (item instanceof MusicCD){
            rental = new MusicCDRental((MusicCD) item, daysRented, transactionTime);
        } else if (item instanceof PlayStation) {
            rental = new PlayStationRental((PlayStation) item, daysRented, transactionTime);
        } else if (item instanceof VideoGame) {
            rental = new VideoGameRental((VideoGame) item, daysRented, transactionTime);
        } else if (item instanceof XBox) {
            rental = new XBoxRental((XBox) item, daysRented, transactionTime);
        }
        return rental;
    }
}
