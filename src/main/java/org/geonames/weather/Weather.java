package org.geonames.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Weather.
 */
public class Weather{

	@JsonProperty("weatherObservation")
	private WeatherObservation weatherObservation;

	/**
	 * Set weather observation.
	 *
	 * @param weatherObservation the weather observation
	 */
	public void setWeatherObservation(WeatherObservation weatherObservation){
		this.weatherObservation = weatherObservation;
	}

	/**
	 * Get weather observation.
	 *
	 * @return the weather observation
	 */
	public WeatherObservation getWeatherObservation(){
		return weatherObservation;
	}

	@Override
 	public String toString(){
		return 
			"Weather{" + 
			"weatherObservation = '" + weatherObservation + '\'' + 
			"}";
		}
}