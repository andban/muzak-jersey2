package de.borntohula.muzak.jersey2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andreas on 24/07/16.
 */
public abstract class Track<R extends Release> {
    private final String title;
    private final R release;

    public Track(String title, R release) {
        this.title = title;
        this.release = release;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("release")
    public R getRelease() {
        return release;
    }
}
