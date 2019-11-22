package edu.utdallas.emse.hw1.rental.movie;

import edu.utdallas.emse.hw1.item.Movie;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "movie-rental")
public class MovieRental extends Rental {

    @Serialized(tag = "is-new-release")
    private final boolean isNewRelease;

    public MovieRental(Movie movie, int daysRented, Instant rentalDate) {
        super(movie, daysRented, rentalDate);
        this.isNewRelease = (getDate().getEpochSecond() - movie.getReleaseDate().getEpochSecond())
                < 5259600L;
    }

    protected PriceStrategy getPriceStrategy() {
        return MovieStrategyFactory.getInstance().getPriceStrategy(this);
    }

    protected FRPStrategy getFRPStrategy() {
        return MovieStrategyFactory.getInstance().getFRPStrategy(this);
    }

    public boolean isNewRelease() {
        return this.isNewRelease;
    }

    public Movie getMovie() {
        return (Movie) getItem();
    }
}
