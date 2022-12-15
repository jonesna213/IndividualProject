package org.geonames.location;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Postal codes item.
 */
public class PostalCodesItem{

	@JsonProperty("adminCode2")
	private String adminCode2;

	@JsonProperty("adminCode1")
	private String adminCode1;

	@JsonProperty("adminName2")
	private String adminName2;

	@JsonProperty("lng")
	private double lng;

	@JsonProperty("countryCode")
	private String countryCode;

	@JsonProperty("postalCode")
	private String postalCode;

	@JsonProperty("adminName1")
	private String adminName1;

	@JsonProperty("ISO3166-2")
	private String iSO31662;

	@JsonProperty("placeName")
	private String placeName;

	@JsonProperty("lat")
	private double lat;

	/**
	 * Set admin code 2.
	 *
	 * @param adminCode2 the admin code 2
	 */
	public void setAdminCode2(String adminCode2){
		this.adminCode2 = adminCode2;
	}

	/**
	 * Get admin code 2 string.
	 *
	 * @return the string
	 */
	public String getAdminCode2(){
		return adminCode2;
	}

	/**
	 * Set admin code 1.
	 *
	 * @param adminCode1 the admin code 1
	 */
	public void setAdminCode1(String adminCode1){
		this.adminCode1 = adminCode1;
	}

	/**
	 * Get admin code 1 string.
	 *
	 * @return the string
	 */
	public String getAdminCode1(){
		return adminCode1;
	}

	/**
	 * Set admin name 2.
	 *
	 * @param adminName2 the admin name 2
	 */
	public void setAdminName2(String adminName2){
		this.adminName2 = adminName2;
	}

	/**
	 * Get admin name 2 string.
	 *
	 * @return the string
	 */
	public String getAdminName2(){
		return adminName2;
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
	 * Set postal code.
	 *
	 * @param postalCode the postal code
	 */
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	/**
	 * Get postal code string.
	 *
	 * @return the string
	 */
	public String getPostalCode(){
		return postalCode;
	}

	/**
	 * Set admin name 1.
	 *
	 * @param adminName1 the admin name 1
	 */
	public void setAdminName1(String adminName1){
		this.adminName1 = adminName1;
	}

	/**
	 * Get admin name 1 string.
	 *
	 * @return the string
	 */
	public String getAdminName1(){
		return adminName1;
	}

	/**
	 * Set iso 31662.
	 *
	 * @param iSO31662 the so 31662
	 */
	public void setISO31662(String iSO31662){
		this.iSO31662 = iSO31662;
	}

	/**
	 * Get iso 31662 string.
	 *
	 * @return the string
	 */
	public String getISO31662(){
		return iSO31662;
	}

	/**
	 * Set place name.
	 *
	 * @param placeName the place name
	 */
	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}

	/**
	 * Get place name string.
	 *
	 * @return the string
	 */
	public String getPlaceName(){
		return placeName;
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
			"PostalCodesItem{" + 
			"adminCode2 = '" + adminCode2 + '\'' + 
			",adminCode1 = '" + adminCode1 + '\'' + 
			",adminName2 = '" + adminName2 + '\'' + 
			",lng = '" + lng + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",adminName1 = '" + adminName1 + '\'' + 
			",iSO3166-2 = '" + iSO31662 + '\'' + 
			",placeName = '" + placeName + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}