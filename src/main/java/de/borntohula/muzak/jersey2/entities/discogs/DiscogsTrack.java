package de.borntohula.muzak.jersey2.entities.discogs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.borntohula.muzak.jersey2.entities.Track;
import jersey.repackaged.com.google.common.collect.ImmutableList;

import java.time.Duration;
import java.util.List;

/**
 * Created by andreas on 24/07/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscogsTrack extends Track<DiscogsRelease> {
    private final String duration;
    private final ImmutableList<DiscogsArtist> extraArtists;

    @JsonCreator
    public DiscogsTrack(@JsonProperty("title") String title,
                        @JsonProperty("duration") String duration,
                        @JsonProperty("release") DiscogsRelease release,
                        @JsonProperty("extraArtists") List<DiscogsArtist> extraArtists) {
        super(title, release);

        this.duration = duration;
        this.extraArtists = extraArtists != null
                ? ImmutableList.copyOf(extraArtists)
                : ImmutableList.of();
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("extraArtists")
    public ImmutableList<DiscogsArtist> getExtraArtists() {
        return extraArtists;
    }
}
