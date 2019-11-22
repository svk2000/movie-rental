package edu.utdallas.emse.hw1.purchase.videogame;

import edu.utdallas.emse.hw1.item.VideoGame;
import edu.utdallas.emse.hw1.purchase.PriceStrategy;
import edu.utdallas.emse.hw1.purchase.Purchase;
import edu.utdallas.emse.hw1.purchase.RewardsPointStrategy;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized(tag = "video-game-purchase")
public class VideoGamePurchase extends Purchase {
    public VideoGamePurchase(VideoGame game, Instant purchaseDate) {
        super(game, purchaseDate);
    }

    @Override
    protected PriceStrategy getPriceStrategy() {
        return VideoGameStrategyFactory.getInstance().getPriceStrategy(this);
    }

    @Override
    protected RewardsPointStrategy getRewardsPointStrategy() {
        return VideoGameStrategyFactory.getInstance().getRewardsPointStrategy(this);
    }

    public VideoGame getVideoGame() {
        return (VideoGame) getItem();
    }
}
