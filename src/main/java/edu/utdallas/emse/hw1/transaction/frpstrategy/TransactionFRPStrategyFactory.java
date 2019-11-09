package edu.utdallas.emse.hw1.transaction.frpstrategy;

import edu.utdallas.emse.hw1.Customer;
import edu.utdallas.emse.hw1.Movie;
import edu.utdallas.emse.hw1.rental.MovieRental;
import edu.utdallas.emse.hw1.rental.Rentable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionFRPStrategyFactory {
    public static TransactionFRPStrategy getStrategy(Customer c, List<Rentable> rentals) {
        int customerAge = c.getAge();

        boolean newReleaseRented = false;
        Set<Movie.Category> movieCategories = new HashSet();
        for (Rentable rental : rentals) {
            if (rental instanceof MovieRental) {
                MovieRental mr = (MovieRental) rental;
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
