package de.borntohula.muzak.jersey2.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jersey.repackaged.com.google.common.collect.ImmutableList;

import java.time.Year;
import java.util.List;

/**
 * Abstract base class for record releases.
 * @param <A> the artist type.
 */
public abstract class Release<A extends Artist> {
    private final String id;
    private final String title;
    private final Year year;
    private final ImmutableList<A> artists;

    public Release(String id, String title, Year year, List<A> artists) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.artists = artists != null
                ? ImmutableList.copyOf(artists)
                : ImmutableList.<A>of();
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("year")
    public Year getYear() {
        return year;
    }

    @JsonProperty("artists")
    public ImmutableList<A> getArtists() {
        return artists;
    }
}
