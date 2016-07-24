package de.borntohula.muzak.jersey2.entities.discogs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.borntohula.muzak.jersey2.entities.Release;
import jersey.repackaged.com.google.common.collect.ImmutableList;

import java.net.URI;
import java.net.URL;
import java.time.Year;
import java.util.List;

/**
 * Created by andreas on 24/07/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscogsRelease extends Release<DiscogsArtist> {
    private final URI uri;
    private final ImmutableList<String> genres;
    private final ImmutableList<String> styles;
    private final DiscogsRating rating;
    private final Integer haves;
    private final Integer wants;
    private final Integer sales;
    private final Double price; // i know, thats the wrong type for money

    @JsonCreator
    public DiscogsRelease(@JsonProperty("id") String id,
                          @JsonProperty("title") String title,
                          @JsonProperty("year") Year year,
                          @JsonProperty("artists") List<DiscogsArtist> artists,
                          @JsonProperty("uri") URI uri,
                          @JsonProperty("genres") List<String> genres,
                          @JsonProperty("styles") List<String> styles,
                          @JsonProperty("rating") DiscogsRating rating,
                          @JsonProperty("numHave") Integer haves,
                          @JsonProperty("numWant") Integer wants,
                          @JsonProperty("numSale") Integer sales,
                          @JsonProperty("lowestPrice") Double price) {
        super(id, title, year, artists);

        this.uri = uri;
        this.genres = genres != null
                ? ImmutableList.copyOf(genres)
                : ImmutableList.of();
        this.styles = styles != null
                ? ImmutableList.copyOf(styles)
                : ImmutableList.of();
        this.rating = rating = rating;
        this.haves = haves;
        this.wants = wants;
        this.sales = sales;
        this.price = price;
    }

    @JsonProperty("uri")
    public URI getUri() {
        return uri;
    }

    @JsonProperty("genres")
    public ImmutableList<String> getGenres() {
        return genres;
    }

    @JsonProperty("styles")
    public ImmutableList<String> getStyles() {
        return styles;
    }

    @JsonProperty("rating")
    public DiscogsRating getRating() {
        return rating;
    }

    @JsonProperty("numHave")
    public Integer getHaves() {
        return haves;
    }

    @JsonProperty("numWant")
    public Integer getWants() {
        return wants;
    }

    @JsonProperty("numSale")
    public Integer getSales() {
        return sales;
    }

    @JsonProperty("lowestPrices")
    public Double getPrice() {
        return price;
    }
}
