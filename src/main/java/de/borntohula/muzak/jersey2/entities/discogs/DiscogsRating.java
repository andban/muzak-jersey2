package de.borntohula.muzak.jersey2.entities.discogs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andreas on 24/07/16.
 */
public class DiscogsRating {
    private final Double score;
    private final Integer votes;

    @JsonCreator
    public DiscogsRating(@JsonProperty("average") Double score, @JsonProperty("count") Integer votes) {
        this.score = score;
        this.votes = votes;
    }

    @JsonProperty("average")
    public Double getScore() {
        return score;
    }

    @JsonProperty("count")
    public Integer getVotes() {
        return votes;
    }
}
