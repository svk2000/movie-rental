package edu.utdallas.emse.hw1.item;

import java.time.Instant;

public class VideoGame {
    private String title;
    private Instant releaseDate;

    public VideoGame(String title, Instant rel) {
        this.title = title;
        this.releaseDate = rel;
    }

    public String getTitle() {
        return this.title;
    }

    public Instant getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
