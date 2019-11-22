package edu.utdallas.emse.hw1.rental.movie;

import edu.utdallas.emse.hw1.item.Movie;
import edu.utdallas.emse.hw1.rental.FRPStrategy;
import edu.utdallas.emse.hw1.rental.movie.points.DefaultMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.movie.points.NewReleaseMovieFRPStrategy;
import edu.utdallas.emse.hw1.rental.PriceStrategy;
import edu.utdallas.emse.hw1.rental.movie.price.DefaultMoviePriceStrategy;
import edu.utdallas.emse.hw1.rental.movie.price.NewReleaseMoviePriceStrategy;

public class MovieStrategyFactory {
    private static final MovieStrategyFactory INSTANCE;

    static {
        INSTANCE = new MovieStrategyFactory();
    }

    private MovieStrategyFactory() {
    }

    public static MovieStrategyFactory getInstance() {
        return INSTANCE;
    }

    public PriceStrategy getPriceStrategy(MovieRental rental) {
        Movie movie = (Movie) rental.getItem();

        return movie.getCategory() == Movie.Category.CHILDRENS || !rental.isNewRelease() ?
                DefaultMoviePriceStrategy.getInstance() : NewReleaseMoviePriceStrategy.getInstance();
    }

    public FRPStrategy getFRPStrategy(MovieRental rental) {
        Movie movie = (Movie) rental.getItem();

        return movie.getCategory() == Movie.Category.CHILDRENS || !rental.isNewRelease() ?
                DefaultMovieFRPStrategy.getInstance() : NewReleaseMovieFRPStrategy.getInstance();
    }
}
