package org.geonames.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather{

	@JsonProperty("weatherObservation")
	private WeatherObservation weatherObservation;

	public void setWeatherObservation(WeatherObservation weatherObservation){
		this.weatherObservation = weatherObservation;
	}

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