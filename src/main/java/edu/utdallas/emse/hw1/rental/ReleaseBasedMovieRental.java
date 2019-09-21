package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.core.Movie;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

public class ReleaseBasedMovieRental extends MovieRental {

    @Serialized(tag = "is-new-release")
    private boolean isNewRelease;

    ReleaseBasedMovieRental(Movie movie, int daysRented, Instant rentalDate) {
        super(movie, daysRented);

        /* New release if rented within 2 months of movie release */
        this.isNewRelease = (rentalDate.getEpochSecond() - movie.getReleaseDate().getEpochSecond())
                < 5259600L;
    }

    @Override
    protected double calculatePrice() {
        return isNewRelease ? getDaysRented() * 3 : super.calculatePrice();
    }

    @Override
    protected int calculateFrequentRenterPoints() {
        int bonusPts = (isNewRelease && getDaysRented() > 1) ? 1 : 0;
        return bonusPts + super.calculateFrequentRenterPoints();
    }
}
