package edu.utdallas.emse.hw1.item;

import java.time.Instant;

public class MusicCD implements Item {
    private String title;
    private String artist;
    private Instant releaseDate;

    public MusicCD(String title, String artist, Instant release) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = release;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return getArtist() + " - " + getTitle();
    }
}
