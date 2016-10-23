package com.challenge.restservice;

import java.util.ArrayList;
import java.util.List;

/**
 * FilmDAO for creating Film samples
 * @author Li
 *
 */

public class FilmDAO {
	
	public List<Film> getSomeTestFilms() {
		Film a = new Film("Inception", "Dream");
		Film b = new Film("Shutter Island","Island");
		Film c = new Film("The Great Gatsby", "Chicago");
		Film d = new Film("The Wolf of Wallstreet", "New York");
		
		List<Film> l = new ArrayList<Film>();
		l.add(a);
		l.add(b);
		l.add(c);
		l.add(d);
		
		return l;
	} 
	
}
