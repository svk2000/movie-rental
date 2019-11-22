package edu.utdallas.emse.hw1.purchase.musiccd;

import edu.utdallas.emse.hw1.item.MusicCD;
import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "music-cd-purchase")
public class MusicCDPurchase extends Purchase {
    public MusicCDPurchase(MusicCD cd, Instant purchaseDate) {
        super(cd, purchaseDate);
    }

    @Override
    protected PriceStrategy getPriceStrategy() {
        return MusicCDStrategyFactory.getInstance().getPriceStrategy(this);
    }

    @Override
    protected RewardsPointStrategy getRewardsPointStrategy() {
        return MusicCDStrategyFactory.getInstance().getRewardsPointStrategy(this);
    }

    public MusicCD getCD() {
        return (MusicCD) getItem();
    }
}
