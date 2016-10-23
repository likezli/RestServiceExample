package com.challenge.restservice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Rest Service based on Jersey Rest API 1.19
 * Jackson 2.8.1 used as JSON library
 * @author Li
 *
 */

@Path("/test")
public class FilmService {
	
	
	/**
	 * test Rest service with plain text output 
	 * @return plain text "Hello World"
	 */
	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello World";
	}
	
	/**
	 * test REST service with samples created from FilmDAO
	 * @return list with film POJO's in JSON
	 */
	@Path("/samples")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> returnFilmJson() {
		List<Film> filmList = new ArrayList<Film>();
		FilmDAO dao = new FilmDAO();
		filmList = dao.getSomeTestFilms();
		return filmList;
	}
	
	/**
	 * configure a mapper to deserialize json array to a list of film POJO's
	 * only read the fields "title" and "locations
	 * @return list with film POJO's containing fields "title" and "locations"
	 */
	@Path("/getAllFilms")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> returnAllFilms() {
		List<Film> filmList = new ArrayList<Film>();
		
		// ignore other fields but "title" and "locations"
		ObjectMapper mapper = new ObjectMapper().configure
				(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,  false);
		
		// JSON array deserialization starts here
		try {
			filmList = mapper.readValue(new URL("https://data.sfgov.org/resource/wwmu-gmzc.json"), new TypeReference<List<Film>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filmList;
	} 
}
