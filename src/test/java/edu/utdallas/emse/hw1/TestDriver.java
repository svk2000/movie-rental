package edu.utdallas.emse.hw1;

import edu.utdallas.emse.hw1.item.*;
import edu.utdallas.emse.hw1.purchase.PurchaseFactory;
import edu.utdallas.emse.hw1.purchase.movie.MoviePurchase;
import edu.utdallas.emse.hw1.purchase.musiccd.MusicCDPurchase;
import edu.utdallas.emse.hw1.purchase.playstation.PlayStationPurchase;
import edu.utdallas.emse.hw1.purchase.videogame.VideoGamePurchase;
import edu.utdallas.emse.hw1.purchase.xbox.XBoxPurchase;
import edu.utdallas.emse.hw1.rental.RentalFactory;
import edu.utdallas.emse.hw1.rental.movie.MovieRental;
import edu.utdallas.emse.hw1.rental.musiccd.MusicCDRental;
import edu.utdallas.emse.hw1.rental.playstation.PlayStationRental;
import edu.utdallas.emse.hw1.rental.videogame.VideoGameRental;
import edu.utdallas.emse.hw1.rental.xbox.XBoxRental;
import edu.utdallas.emse.hw1.transaction.Transaction;
import edu.utdallas.emse.hw1.serialization.ObjectSerializer;
import edu.utdallas.emse.hw1.serialization.XMLSerializer;
import edu.utdallas.emse.hw1.transaction.TransactionItem;

import java.time.Instant;
import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Independence Day", Movie.Category.ACTION, Instant.parse("1996-07-03T00:00:00.00Z"));
        Movie movie2 = new Movie("Latest Comic Book Movie", Movie.Category.ACTION, Instant.now());
        Movie movie3 = new Movie("Dumbo", Movie.Category.CHILDRENS, Instant.parse("1941-10-23T00:00:00.00Z"));
        Movie movie4 = new Movie("Dumbo: Even Dumber", Movie.Category.CHILDRENS, Instant.now());

        VideoGame vg1 = new VideoGame("Mario Bros. for PS4", Instant.parse("1986-07-03T00:00:00.00Z"));
        VideoGame vg2 = new VideoGame("Mario Bros. for XBoxOne", Instant.parse("1986-07-03T00:00:00.00Z"));

        MusicCD cd1 = new MusicCD("Cheezy Pop Love Songs", "New Backstreet Boys on the Block", Instant.now());

        PlayStation ps = new PlayStation(4);
        XBox xbox = new XBox(XBox.Type.XBOX_ONE);

        Customer customer = new Customer("John Smith", 22);
        Instant transactionTime = Instant.now();

        ArrayList<TransactionItem> transactionItems = new ArrayList();

        /* RENTALS */
        transactionItems.add(RentalFactory.getRental(movie1, 3));
        transactionItems.add(RentalFactory.getRental(movie2, 2));
        transactionItems.add(RentalFactory.getRental(movie3, 1));
        transactionItems.add(RentalFactory.getRental(movie4, 2));
        transactionItems.add(RentalFactory.getRental(vg1, 5));
        transactionItems.add(RentalFactory.getRental(vg2, 6));
        transactionItems.add(RentalFactory.getRental(cd1, 10));
        transactionItems.add(RentalFactory.getRental(ps, 5));
        transactionItems.add(RentalFactory.getRental(xbox, 6));

        /* PURCHASES */
        transactionItems.add(PurchaseFactory.getPurchase(movie1));
        transactionItems.add(PurchaseFactory.getPurchase(vg1));
        transactionItems.add(PurchaseFactory.getPurchase(cd1));
        transactionItems.add(PurchaseFactory.getPurchase(ps));
        transactionItems.add(PurchaseFactory.getPurchase(xbox));

        Transaction transaction1 = new Transaction(customer, transactionItems);

        String expected =
                "Rental Record for John Smith\n" +
                        "\tIndependence Day\t3.50\n" +
                        "\tLatest Comic Book Movie\t6.00\n" +
                        "\tDumbo\t1.50\n" +
                        "\tDumbo: Even Dumber\t1.50\n" +
                        "Amount owed is 12.5\n" +
                        "You earned 5 frequent renter points";

        String statement = customer.getStatement();
        System.out.println(statement);
        System.out.println();

        Transaction transaction2 = new Transaction(customer, transactionItems);
        statement = customer.getStatement();
        System.out.println(statement);
//        assert statement.equals(expected);

        String expectedXML =
                "<customer>\n" +
                        "\t<name>John Smith</name>\n" +
                        "\t<rentals>\n" +
                        "\t\t<movie-rental>\n" +
                        "\t\t\t<movie>Independence Day</movie>\n" +
                        "\t\t\t<is-new-release>false</is-new-release>\n" +
                        "\t\t\t<days-rented>3</days-rented>\n" +
                        "\t\t\t<total-price>3.5</total-price>\n" +
                        "\t\t\t<frequent-renter-points>1</frequent-renter-points>\n" +
                        "\t\t</movie-rental>\n" +
                        "\t\t<movie-rental>\n" +
                        "\t\t\t<movie>Latest Comic Book Movie</movie>\n" +
                        "\t\t\t<is-new-release>true</is-new-release>\n" +
                        "\t\t\t<days-rented>2</days-rented>\n" +
                        "\t\t\t<total-price>6.0</total-price>\n" +
                        "\t\t\t<frequent-renter-points>2</frequent-renter-points>\n" +
                        "\t\t</movie-rental>\n" +
                        "\t\t<movie-rental>\n" +
                        "\t\t\t<movie>Dumbo</movie>\n" +
                        "\t\t\t<is-new-release>false</is-new-release>\n" +
                        "\t\t\t<days-rented>1</days-rented>\n" +
                        "\t\t\t<total-price>1.5</total-price>\n" +
                        "\t\t\t<frequent-renter-points>1</frequent-renter-points>\n" +
                        "\t\t</movie-rental>\n" +
                        "\t\t<movie-rental>\n" +
                        "\t\t\t<movie>Dumbo: Even Dumber</movie>\n" +
                        "\t\t\t<is-new-release>true</is-new-release>\n" +
                        "\t\t\t<days-rented>2</days-rented>\n" +
                        "\t\t\t<total-price>1.5</total-price>\n" +
                        "\t\t\t<frequent-renter-points>1</frequent-renter-points>\n" +
                        "\t\t</movie-rental>\n" +
                        "\t</rentals>\n" +
                        "\t<amount-owed>12.5</amount-owed>\n" +
                        "\t<frequent-renter-points>5</frequent-renter-points>\n" +
                        "</customer>\n";
        ObjectSerializer os = new XMLSerializer(customer);
        String xml = os.serialize();
//        System.out.println(xml);
//        assert xml.equals(expectedXML);
    }
}