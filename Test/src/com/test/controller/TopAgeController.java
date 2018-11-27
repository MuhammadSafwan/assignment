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

import com.test.model.Age;
import com.test.model.Movie;
import com.test.service.MovieService;

/**
 * @author Safwan
 *
 */
@Controller
public class TopAgeController {
	
	protected static Logger logger = Logger.getLogger("TopAgeController");
	 
	private MovieService movieService;
	
	@Autowired 
	public TopAgeController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(value = "/age", method = RequestMethod.GET)
	public String showTopMoviesWithAge(Map<String, Object> model, HttpServletRequest request) {		
 
		logger.info("entering showTopMoviesWithAge");
		
		String movieParam = request.getParameter("age");
		Age searchedAge = new Age();
 
		List<Movie> movie = movieService.getTopWithAge(Integer.parseInt(movieParam));
		model.put("movie", movie);		
		model.put("searchedAge", searchedAge);
 
	    	return "topWithAge";
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpSession httpSession,
			@ModelAttribute("anyRequestObject") Object anyRequestObject, BindingResult errors,
			@ModelAttribute("searchMovie") Age searchedAge) {

		if (errors.hasErrors()) {
			// return error view
		}

		return "redirect:/age.html?age=" + searchedAge.getId();
	}*/

}
