package edu.utdallas.emse.hw1;

import edu.utdallas.emse.hw1.core.Customer;
import edu.utdallas.emse.hw1.core.Movie;
import edu.utdallas.emse.hw1.rental.MovieRental;
import edu.utdallas.emse.hw1.rental.Rental;
import edu.utdallas.emse.hw1.serialization.ObjectSerializer;
import edu.utdallas.emse.hw1.serialization.XMLSerializer;

import java.time.Instant;

public class TestDriver {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Independence Day", Movie.Category.ACTION, Instant.parse("1996-07-03T00:00:00.00Z"));
        Movie movie2 = new Movie("Latest Comic Book Movie", Movie.Category.ACTION, Instant.now());
        Movie movie3 = new Movie("Dumbo", Movie.Category.CHILDRENS, Instant.parse("1941-10-23T00:00:00.00Z"));

        Customer test = new Customer("John Smith");
        Instant rentalTime = Instant.now();
        Rental rental1 = new MovieRental(movie1, 3, rentalTime);
        Rental rental2 = new MovieRental(movie2, 2, rentalTime);
        Rental rental3 = new MovieRental(movie3, 1, rentalTime);

        test.addRental(rental1);
        test.addRental(rental2);
        test.addRental(rental3);

        System.out.println(test.statement());

        ObjectSerializer os = new XMLSerializer(test);

        try {
            System.out.println(os.serialize());
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}