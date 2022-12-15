package org.geonames.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Weather observation.
 */
public class WeatherObservation{

	@JsonProperty("elevation")
	private int elevation;

	@JsonProperty("lng")
	private double lng;

	@JsonProperty("observation")
	private String observation;

	@JsonProperty("ICAO")
	private String iCAO;

	@JsonProperty("clouds")
	private String clouds;

	@JsonProperty("dewPoint")
	private String dewPoint;

	@JsonProperty("cloudsCode")
	private String cloudsCode;

	@JsonProperty("datetime")
	private String datetime;

	@JsonProperty("seaLevelPressure")
	private double seaLevelPressure;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("temperature")
	private String temperature;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("stationName")
	private String stationName;

	@JsonProperty("weatherCondition")
	private String weatherCondition;

	@JsonProperty("windDirection")
	private int windDirection;

	@JsonProperty("windSpeed")
	private String windSpeed;

	@JsonProperty("lat")
	private double lat;

	/**
	 * Set elevation.
	 *
	 * @param elevation the elevation
	 */
	public void setElevation(int elevation){
		this.elevation = elevation;
	}

	/**
	 * Get elevation int.
	 *
	 * @return the int
	 */
	public int getElevation(){
		return elevation;
	}

	/**
	 * Set lng.
	 *
	 * @param lng the lng
	 */
	public void setLng(double lng){
		this.lng = lng;
	}

	/**
	 * Get lng double.
	 *
	 * @return the double
	 */
	public double getLng(){
		return lng;
	}

	/**
	 * Set observation.
	 *
	 * @param observation the observation
	 */
	public void setObservation(String observation){
		this.observation = observation;
	}

	/**
	 * Get observation string.
	 *
	 * @return the string
	 */
	public String getObservation(){
		return observation;
	}

	/**
	 * Set icao.
	 *
	 * @param iCAO the cao
	 */
	public void setICAO(String iCAO){
		this.iCAO = iCAO;
	}

	/**
	 * Get icao string.
	 *
	 * @return the string
	 */
	public String getICAO(){
		return iCAO;
	}

	/**
	 * Set clouds.
	 *
	 * @param clouds the clouds
	 */
	public void setClouds(String clouds){
		this.clouds = clouds;
	}

	/**
	 * Get clouds string.
	 *
	 * @return the string
	 */
	public String getClouds(){
		return clouds;
	}

	/**
	 * Set dew point.
	 *
	 * @param dewPoint the dew point
	 */
	public void setDewPoint(String dewPoint){
		this.dewPoint = dewPoint;
	}

	/**
	 * Get dew point string.
	 *
	 * @return the string
	 */
	public String getDewPoint(){
		return dewPoint;
	}

	/**
	 * Set clouds code.
	 *
	 * @param cloudsCode the clouds code
	 */
	public void setCloudsCode(String cloudsCode){
		this.cloudsCode = cloudsCode;
	}

	/**
	 * Get clouds code string.
	 *
	 * @return the string
	 */
	public String getCloudsCode(){
		return cloudsCode;
	}

	/**
	 * Set datetime.
	 *
	 * @param datetime the datetime
	 */
	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	/**
	 * Get datetime string.
	 *
	 * @return the string
	 */
	public String getDatetime(){
		return datetime;
	}

	/**
	 * Set sea level pressure.
	 *
	 * @param seaLevelPressure the sea level pressure
	 */
	public void setSeaLevelPressure(double seaLevelPressure){
		this.seaLevelPressure = seaLevelPressure;
	}

	/**
	 * Get sea level pressure double.
	 *
	 * @return the double
	 */
	public double getSeaLevelPressure(){
		return seaLevelPressure;
	}

	/**
	 * Set country code.
	 *
	 * @param countryCode the country code
	 */
	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	/**
	 * Get country code string.
	 *
	 * @return the string
	 */
	public String getCountryCode(){
		return countryCode;
	}

	/**
	 * Set temperature.
	 *
	 * @param temperature the temperature
	 */
	public void setTemperature(String temperature){
		this.temperature = temperature;
	}

	/**
	 * Get temperature string.
	 *
	 * @return the string
	 */
	public String getTemperature(){
		return temperature;
	}

	/**
	 * Set humidity.
	 *
	 * @param humidity the humidity
	 */
	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	/**
	 * Get humidity int.
	 *
	 * @return the int
	 */
	public int getHumidity(){
		return humidity;
	}

	/**
	 * Set station name.
	 *
	 * @param stationName the station name
	 */
	public void setStationName(String stationName){
		this.stationName = stationName;
	}

	/**
	 * Get station name string.
	 *
	 * @return the string
	 */
	public String getStationName(){
		return stationName;
	}

	/**
	 * Set weather condition.
	 *
	 * @param weatherCondition the weather condition
	 */
	public void setWeatherCondition(String weatherCondition){
		this.weatherCondition = weatherCondition;
	}

	/**
	 * Get weather condition string.
	 *
	 * @return the string
	 */
	public String getWeatherCondition(){
		return weatherCondition;
	}

	/**
	 * Set wind direction.
	 *
	 * @param windDirection the wind direction
	 */
	public void setWindDirection(int windDirection){
		this.windDirection = windDirection;
	}

	/**
	 * Get wind direction int.
	 *
	 * @return the int
	 */
	public int getWindDirection(){
		return windDirection;
	}

	/**
	 * Set wind speed.
	 *
	 * @param windSpeed the wind speed
	 */
	public void setWindSpeed(String windSpeed){
		this.windSpeed = windSpeed;
	}

	/**
	 * Get wind speed string.
	 *
	 * @return the string
	 */
	public String getWindSpeed(){
		return windSpeed;
	}

	/**
	 * Set lat.
	 *
	 * @param lat the lat
	 */
	public void setLat(double lat){
		this.lat = lat;
	}

	/**
	 * Get lat double.
	 *
	 * @return the double
	 */
	public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"WeatherObservation{" + 
			"elevation = '" + elevation + '\'' + 
			",lng = '" + lng + '\'' + 
			",observation = '" + observation + '\'' + 
			",iCAO = '" + iCAO + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",cloudsCode = '" + cloudsCode + '\'' + 
			",datetime = '" + datetime + '\'' + 
			",seaLevelPressure = '" + seaLevelPressure + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",temperature = '" + temperature + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",stationName = '" + stationName + '\'' + 
			",weatherCondition = '" + weatherCondition + '\'' + 
			",windDirection = '" + windDirection + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}