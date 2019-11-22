package edu.utdallas.emse.hw1.purchase.movie;

import edu.utdallas.emse.hw1.item.Movie;
import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "movie-purchase")
public class MoviePurchase extends Purchase {
    public MoviePurchase(Movie movie, Instant purchaseDate) {
        super(movie, purchaseDate);
    }

    @Override
    protected PriceStrategy getPriceStrategy() {
        return MovieStrategyFactory.getInstance().getPriceStrategy(this);
    }

    @Override
    protected RewardsPointStrategy getRewardsPointStrategy() {
        return MovieStrategyFactory.getInstance().getRewardsPointStrategy(this);
    }

    public Movie getMovie() {
        return (Movie) getItem();
    }
}
