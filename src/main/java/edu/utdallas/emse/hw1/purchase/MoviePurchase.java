package edu.utdallas.emse.hw1.purchase;

import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.serialization.Serialized;

@Serialized(tag = "movie-purchase")
public class MoviePurchase implements Purchaseable {
    @Serialized
    private Movie movie;

    public MoviePurchase(Movie movie) {
        this.movie = movie;
    }

    public double getPurchasePrice() {
        return 10.0;
    }

    @Override
    public String toString() {
        return String.format("%s\t%.2f", getMovie().toString(), getPurchasePrice());
    }

    private Movie getMovie() {
        return this.movie;
    }
}
