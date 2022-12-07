package com.hondaparts.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Gets a pet by the id provided.
     *
     * @param id the id of a pet
     * @return the pet object containing the info of the id provided
     */
    public Pet getPet(int id) {
        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/" + id);
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = null;

        try {
            pet = mapper.readValue(response, Pet.class);
        } catch (JsonProcessingException e) {
            logger.error("Json exception:", e);
        }

        return pet;
    }
}
