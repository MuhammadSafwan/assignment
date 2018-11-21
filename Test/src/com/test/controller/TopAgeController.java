/**
 * 
 */
package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Movie;
import com.test.service.MovieService;

/**
 * @author Safwan
 *
 */
@Controller
public class TopAgeController {
	
	protected static Logger logger = Logger.getLogger("TopHundredController");
	 
	private MovieService movieService;
	
	@Autowired 
	public TopAgeController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(value = "/age", method = RequestMethod.GET)
	public String showTopMovies(Map<String, Object> model, HttpServletRequest request) {		
 
		logger.info("entering showTopMovies");
		
		String movieParam = request.getParameter("age");
		System.out.println(movieParam);
 
		List<Movie> movie = movieService.getTopWithAge(Integer.parseInt(movieParam));
		model.put("movie", movie);		
		//System.out.println(movie.get(0));
 
	    	// This will resolve to /WEB-INF/jsp/greetings.jsp
	    	return "topWithAge";
	}

}
