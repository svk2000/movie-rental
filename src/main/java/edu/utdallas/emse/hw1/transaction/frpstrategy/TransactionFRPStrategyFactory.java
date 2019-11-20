package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.Customer;
import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.rental.movie.MovieRental;
import edu.utdallas.emse.hw1.transaction.TransactionItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionFRPStrategyFactory {
    public static TransactionFRPStrategy getStrategy(Customer c, List<TransactionItem> items) {
        int customerAge = c.getAge();

        boolean newReleaseRented = false;
        Set<Movie.Category> movieCategories = new HashSet();
        for (TransactionItem item : items) {
            if (item instanceof MovieRental) {
                MovieRental mr = (MovieRental) item;
                movieCategories.add(mr.getMovie().getCategory());
                newReleaseRented |= mr.isNewRelease();
            }
        }

        if (customerAge > 17 && customerAge < 23 && newReleaseRented) {
            return AgeFRPStrategy.getInstance();
        } else if (movieCategories.size() > 1) {
            return MultiCategoryFRPStrategy.getInstance();
        } else {
            return DefaultFRPStrategy.getInstance();
        }
    }
}
