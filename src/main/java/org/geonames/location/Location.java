package org.geonames.location;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Location.
 */
public class Location{

	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	/**
	 * Set postal codes.
	 *
	 * @param postalCodes the postal codes
	 */
	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	/**
	 * Get postal codes list.
	 *
	 * @return the list
	 */
	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"postalCodes = '" + postalCodes + '\'' + 
			"}";
		}
}