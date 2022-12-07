package com.hondaparts.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geonames.location.Location;
import org.geonames.weather.Weather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets the temperature of the provided zip.
     *
     * @param zip the zip code to get the temperature for
     * @return the temperature
     */
    public String getTemperature(String zip) {
        Location location = getLocation(zip);

        String lat = String.valueOf(location.getPostalCodes().get(0).getLat());
        String lng = String.valueOf(location.getPostalCodes().get(0).getLng());

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearByWeatherJSON?lat=" + lat + "&lng=" + lng + "&username=njones11");
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = null;
        String temp = null;

        try {
            weather = mapper.readValue(response, Weather.class);
            temp = weather.getWeatherObservation().getTemperature();
        } catch (JsonProcessingException e) {
            logger.error("Json exception:", e);
        }

        return temp;
    }

    /**
     * Gets the location from the provided zip.
     *
     * @param zip the zip code
     * @return a location object
     */
    public Location getLocation(String zip) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/postalCodeSearchJSON?username=njones11&postalcode=" +
                        zip + "&country=US");
        String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Location location = null;

        try {
            location = mapper.readValue(response, Location.class);
        } catch (JsonProcessingException e) {
            logger.error("Json exception:", e);
        }

        return location;
    }
}
