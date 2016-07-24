package de.borntohula.muzak.jersey2.entities.discogs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andreas on 24/07/16.
 */
public class DiscogsResponse {
    private final DiscogsTrack result;

    @JsonCreator
    public DiscogsResponse(@JsonProperty("result") DiscogsTrack result) {
        this.result = result;
    }

    @JsonProperty("result")
    public DiscogsTrack getResult() {
        return result;
    }
}
