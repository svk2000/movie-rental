package edu.utdallas.emse.hw1.purchase.playstation;

import edu.utdallas.emse.hw1.item.PlayStation;
import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "playstation-purchase")
public class PlayStationPurchase extends Purchase {
    public PlayStationPurchase(PlayStation ps, Instant purchaseDate) {
        super(ps, purchaseDate);
    }

    @Override
    protected PriceStrategy getPriceStrategy() {
        return PlayStationStrategyFactory.getInstance().getPriceStrategy(this);
    }

    @Override
    protected RewardsPointStrategy getRewardsPointStrategy() {
        return PlayStationStrategyFactory.getInstance().getRewardsPointStrategy(this);
    }

    public PlayStation getPlayStation() {
        return (PlayStation) getItem();
    }
}
