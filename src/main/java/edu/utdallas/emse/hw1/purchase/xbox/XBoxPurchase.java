package edu.utdallas.emse.hw1.purchase.xbox;

import edu.utdallas.emse.hw1.item.XBox;
import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "xbox-purchase")
public class XBoxPurchase extends Purchase {
    public XBoxPurchase(XBox xbox, Instant purchaseDate) {
        super(xbox, purchaseDate);
    }

    @Override
    protected PriceStrategy getPriceStrategy() {
        return XBoxStrategyFactory.getInstance().getPriceStrategy(this);
    }

    @Override
    protected RewardsPointStrategy getRewardsPointStrategy() {
        return XBoxStrategyFactory.getInstance().getRewardsPointStrategy(this);
    }

    public XBox getXBox() {
        return (XBox) getItem();
    }
}
