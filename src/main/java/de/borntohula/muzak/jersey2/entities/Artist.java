package de.borntohula.muzak.jersey2.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by andreas on 24/07/16.
 */
public abstract class Artist {
    private final String id;
    private final String name;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
}
