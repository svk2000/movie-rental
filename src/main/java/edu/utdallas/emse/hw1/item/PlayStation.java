package edu.utdallas.emse.hw1.item;

public class PlayStation implements Item {
    private final int generation;

    public PlayStation(int gen) {
        this.generation = gen;
    }

    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return "PlayStation " + getGeneration();
    }
}
