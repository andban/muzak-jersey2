package de.borntohula.muzak.jersey2.entities.discogs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.borntohula.muzak.jersey2.entities.Artist;

import java.net.URL;

/**
 * Created by andreas on 24/07/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscogsArtist extends Artist {
    private final URL url;
    private final String role;

    @JsonCreator
    public DiscogsArtist(@JsonProperty("id") String id,
                         @JsonProperty("name") String name,
                         @JsonProperty("resource_url") URL url,
                         @JsonProperty("role") String role) {
        super(id, name);
        this.url = url;
        this.role = role;
    }

    @JsonProperty("resource_url")
    public URL getUrl() {
        return url;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }
}
