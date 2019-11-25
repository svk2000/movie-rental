package edu.utdallas.emse.hw1.purchase;

import edu.utdallas.emse.hw1.item.*;
import edu.utdallas.emse.hw1.purchase.movie.MoviePurchase;
import edu.utdallas.emse.hw1.purchase.musiccd.MusicCDPurchase;
import edu.utdallas.emse.hw1.purchase.playstation.PlayStationPurchase;
import edu.utdallas.emse.hw1.purchase.videogame.VideoGamePurchase;
import edu.utdallas.emse.hw1.purchase.xbox.XBoxPurchase;

import java.time.Instant;

public class PurchaseFactory {

    public static Purchase getPurchase(Item item){
        Purchase purchase = null;
        Instant transactionTime = Instant.now();

        if (item instanceof Movie) {
            purchase = new MoviePurchase((Movie)item, transactionTime);
        } else if (item instanceof MusicCD){
            purchase = new MusicCDPurchase((MusicCD) item, transactionTime);
        } else if (item instanceof PlayStation) {
            purchase = new PlayStationPurchase((PlayStation) item, transactionTime);
        } else if (item instanceof VideoGame) {
            purchase = new VideoGamePurchase((VideoGame) item, transactionTime);
        } else if (item instanceof XBox) {
            purchase = new XBoxPurchase((XBox) item, transactionTime);
        }
        return purchase;
    }
}
