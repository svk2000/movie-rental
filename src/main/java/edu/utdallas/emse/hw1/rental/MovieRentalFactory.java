package edu.utdallas.emse.hw1.rental;

import edu.utdallas.emse.hw1.core.Movie;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovieRentalFactory {
    private static final Map<Movie.Category, Class<MovieRental>> RENTAL_TYPE;

    static {
        final Map<Movie.Category, Class<MovieRental>> tmpPC = new ConcurrentHashMap<>();
        tmpPC.put(Movie.Category.CHILDRENS, MovieRental.class);
        RENTAL_TYPE = Collections.unmodifiableMap(tmpPC);
    }

    private MovieRentalFactory() {
    }

    public static MovieRental getMovieRental(Movie movie, int daysRented, Instant rentalDate) {
        Class<? extends MovieRental> mr = RENTAL_TYPE.get(movie.getCategory());
        if (mr == MovieRental.class) {
            return new MovieRental(movie, daysRented);
        }

        return new ReleaseBasedMovieRental(movie, daysRented, rentalDate);
    }
}
