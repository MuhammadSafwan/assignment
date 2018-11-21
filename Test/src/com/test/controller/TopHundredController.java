/**
 * 
 */
package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Age;
import com.test.model.Movie;
import com.test.service.AgeService;
import com.test.service.MovieService;

/**
 * @author Safwan
 *
 */

@Controller
public class TopHundredController {

	protected static Logger logger = Logger.getLogger("TopHundredController");

	private MovieService movieService;
	private AgeService ageService;

	@Autowired
	public TopHundredController(MovieService movieService, AgeService ageService) {
		this.movieService = movieService;
		this.ageService = ageService;
	}

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String showTopMovies(Map<String, Object> model) {

		logger.info("entering showTopMovies");

		List<Movie> movie = movieService.getTop100();
		List<Age> age = ageService.getAllAges();
		String searchMovie = "";
		Age searchedAge = new Age();

		model.put("movie", movie);
		model.put("age", age);
		model.put("searchMovie", searchMovie);
		model.put("searchedAge", searchedAge);
		// System.out.println(movie.get(0));

		// This will resolve to /WEB-INF/jsp/greetings.jsp
		return "top";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpSession httpSession,
			@ModelAttribute("anyRequestObject") Object anyRequestObject, BindingResult errors,
			@ModelAttribute("searchMovie") Age searchedAge) {

		if (errors.hasErrors()) {
			// return error view
		}

		return "redirect:/age.html?age=" + searchedAge.getId();
	}

}
