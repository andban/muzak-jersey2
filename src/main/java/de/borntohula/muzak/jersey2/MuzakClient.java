package de.borntohula.muzak.jersey2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.borntohula.muzak.jersey2.entities.Track;
import de.borntohula.muzak.jersey2.entities.discogs.DiscogsRelease;
import de.borntohula.muzak.jersey2.entities.discogs.DiscogsResponse;
import de.borntohula.muzak.jersey2.entities.discogs.DiscogsTrack;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

/**
 * Created by andreas on 24/07/16.
 */
public class MuzakClient {
    private final String baseUrl;
    private final String apiKey;
    private final Client client;

    public MuzakClient(String baseUrl, String apiKey) {
        this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl must not be null");
        this.apiKey = Objects.requireNonNull(apiKey, "apiKey must not be null");

        this.client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }

    public Track<?> fetchMetaData(String track, String artist) throws ClientErrorException {
        final Response response = client.target(baseUrl).path("/discogs-query")
                .queryParam("track", track)
                .queryParam("artist", artist)
                .request(MediaType.APPLICATION_JSON)
                .header("x-api-key", apiKey)
                .get();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new ClientErrorException(response.getStatus());
        }

        final DiscogsResponse result = response.readEntity(DiscogsResponse.class);

        return result.getResult();
    }

    public static void main(String[] args) throws JsonProcessingException {
        MuzakClient client = new MuzakClient(
                args[0],
                args[1]);

        Track<?> t = client.fetchMetaData("Where is my mind", "Pixies");

        ObjectMapper om = new ObjectMapper();
        System.out.println("response: " + om.writeValueAsString(t));
    }
}
