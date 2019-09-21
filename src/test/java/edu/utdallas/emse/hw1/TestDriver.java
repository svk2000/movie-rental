package edu.utdallas.emse.hw1;

import edu.utdallas.emse.hw1.core.Customer;
import edu.utdallas.emse.hw1.core.Movie;
import edu.utdallas.emse.hw1.rental.MovieRentalFactory;
import edu.utdallas.emse.hw1.serialization.ObjectSerializer;
import edu.utdallas.emse.hw1.serialization.XMLSerializer;

import java.time.Instant;

public class TestDriver {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Independence Day", Movie.Category.ACTION, Instant.parse("1996-07-03T00:00:00.00Z"));
        Movie movie2 = new Movie("Latest Comic Book Movie", Movie.Category.ACTION, Instant.now());
        Movie movie3 = new Movie("Dumbo", Movie.Category.CHILDRENS, Instant.parse("1941-10-23T00:00:00.00Z"));
        Movie movie4 = new Movie("Dumbo: Even Dumber", Movie.Category.CHILDRENS, Instant.now());

        Customer customer = new Customer("John Smith");
        Instant rentalTime = Instant.now();
        customer.addRental(MovieRentalFactory.getMovieRental(movie1, 3, rentalTime));
        customer.addRental(MovieRentalFactory.getMovieRental(movie2, 2, rentalTime));
        customer.addRental(MovieRentalFactory.getMovieRental(movie3, 1, rentalTime));
        customer.addRental(MovieRentalFactory.getMovieRental(movie4, 2, rentalTime));

        System.out.println(customer.statement());

        ObjectSerializer os = new XMLSerializer(customer);

        try {
            System.out.println(os.serialize());
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}