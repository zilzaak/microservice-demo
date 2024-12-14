package movieinfo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import movieinfo.model.MovieCat;
import movieinfo.model.MovieShow;
import movieinfo.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import movieinfo.model.Movie;

@RestController
@RequestMapping("movie/")
public class Movieresource {

	public static final List<Movie> allMovies = Arrays.asList(
			new Movie(1,10,"Tere Naam","Romantic Thriller"),
			new Movie(2,9,"Dilwale Dulhania Le jainge","Romantic Thriller"),
			new Movie(3,8,"Kuli No 1","Romantic Comedy"),
			new Movie(4,7,"Krish","Action"),
			new Movie(5,6,"Koila","Action"),
			new Movie(6,5,"Dhoom","Action"),
			new Movie(7,4,"Pushpa","Romantic Action"),
			new Movie(8,3,"Bhool Bhulaiya","Horror"),
			new Movie(9,2,"Siccin","Horror"),
			new Movie(10,1,"HUddam 2","Horror"),
			new Movie(11,8,"Gajini","Action Romantic"),
			new Movie(12,10,"Ammazan","Action Thriller"));

	@Autowired
    WebClient.Builder builder = WebClient.builder();
	@Autowired
	RestTemplate rt ;
	
	@RequestMapping(value="/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllMovies() {
		return new ResponseEntity<>( this.allMovies, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping("/rating/{movieId}")
	public Rating getmovierating(@PathVariable Integer movieId) {
		Rating ra=null;
		ResponseEntity<Rating> response = rt.exchange(
				"http://rating-service/rating/"+movieId,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Rating>() {}
		);
		ra=response.getBody();
		return ra;
		
	}
	
	
	
	@RequestMapping("/rating/all")
	public List<Rating> allMovieRatings() {
		List<Rating> mv=new ArrayList<>();
		ResponseEntity<List<Rating>> response = rt.exchange(
				"http://rating-service/rating/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Rating>>() {}
		);
		mv=response.getBody();
		return mv;
	}


	@RequestMapping("/category/{category}")
	public List<MovieCat> movieCat(@PathVariable String category) {
		List<MovieCat> list= new ArrayList<>();
		ResponseEntity<List<MovieCat>> response = rt.exchange(
				"http://category-service/category/" + category,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<MovieCat>>() {}
		);
		list= response.getBody();
		return list;
	}



	@RequestMapping("/category/all")
	public List<MovieCat> allCat() {
		List<MovieCat> list= new ArrayList<>();
		ResponseEntity<List<MovieCat>> response = rt.exchange(
				"http://category-service/category/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<MovieCat>>() {}
		);
		list= response.getBody();
		return list;
	}

	@RequestMapping("/show/{movieId}")
	public ResponseEntity<?> movieShow(@PathVariable Integer movieId) {

		ResponseEntity<MovieShow> response = rt.exchange(
				"http://show-service/show/"+movieId,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<MovieShow>() {}
		);
		MovieShow obj = response.getBody();
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}



}
