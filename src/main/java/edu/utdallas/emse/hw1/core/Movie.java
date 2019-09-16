package edu.utdallas.emse.hw1.core;

import java.time.Instant;

public class Movie {

    public enum Category {
        CHILDRENS, DRAMA, COMEDY, ACTION, THRILLER, DOCUMENTARY
    }

    private String title;

    private Category category;
    private Instant releaseDate;

    //Exception Checks
    public Movie(String title, Category c, Instant release) {
        this.title = title;
        this.category = c;
        this.releaseDate = release;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}