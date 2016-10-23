package com.challenge.restservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO Film
 * @author Li
 *	
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_DEFAULT) 
public class Film {
	
	// set json properties
	@JsonProperty("title")
	private String title;
	@JsonProperty("locations")
	private String locations;
	
	// default constructor
	public Film() {
		super();
	}
	
	public Film(String title, String locations) {
		this.title = title;
		this.locations = locations;
	}
	
	// getter and setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null && !title.equals("")) {
			this.title = title;
		}
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		if(locations != null && !locations.equals("")) {
			this.locations = locations;
		}
	}
	
	public String toString() {
		return "title: " + this.title + " locations: " + this.locations;
	}
}
