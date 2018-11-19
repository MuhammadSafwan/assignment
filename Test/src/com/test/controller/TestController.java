/**
 * 
 */
package com.test.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Movie;
import com.test.service.MovieService;

/**
 * @author Safwan
 *
 */

@Controller
public class TestController {
	
	/*@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		//System.out.println("Here");
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}*/
	
	protected static Logger logger = Logger.getLogger("MovieController");
	 
	private MovieService movieService;
	
	@Autowired 
	public TestController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showAllMovies(Map<String, Object> model) {		
 
		logger.info("entering showAllMovies");
 
		List<Movie> movie = movieService.getAllMovies();
		model.put("movie", movie);		
		//model.put("colorcode", "FFFFFF");
 
	    	// This will resolve to /WEB-INF/jsp/greetings.jsp
	    	return "welcome";
	}

}
