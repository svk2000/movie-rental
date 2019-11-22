package edu.utdallas.emse.hw1.purchase;

import edu.utdallas.emse.hw1.item.Item;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.time.Instant;

@Serialized
public abstract class Purchase implements Purchaseable {
    @Serialized
    private final Item item;

    @Serialized
    private final Instant date;

    @Serialized(tag = "total-price")
    private double totalPrice;

    @Serialized(tag = "rewards-points")
    private int rewardsPoints;

    private PriceStrategy priceStrategy;
    private RewardsPointStrategy rpStrategy;

    public Purchase(Item purchaseItem, Instant purchaseDate) {
        this.item = purchaseItem;
        this.date = purchaseDate;
    }

    protected abstract PriceStrategy getPriceStrategy();

    protected abstract RewardsPointStrategy getRewardsPointStrategy();

    @Override
    public Item getItem() {
        return this.item;
    }

    @Override
    public double getPurchasePrice() {
        if (totalPrice > 0) {
            return totalPrice;
        }

        totalPrice = calculatePrice();
        return totalPrice;
    }

    private double calculatePrice() {
        if (priceStrategy == null) {
            priceStrategy = getPriceStrategy();
        }

        return priceStrategy.getPrice(this);
    }

    @Override
    public int getRewardsPoints() {
        if (rewardsPoints == 0) {
            rewardsPoints = calculateRewardsPoints();
        }

        return rewardsPoints;
    }

    private int calculateRewardsPoints() {
        if (rpStrategy == null) {
            rpStrategy = getRewardsPointStrategy();
        }

        return rpStrategy.getRewardsPoints(this);
    }

    @Override
    public Instant getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("PURCHASE: %s\t%.2f", getItem().toString(), getPurchasePrice());
    }
}
