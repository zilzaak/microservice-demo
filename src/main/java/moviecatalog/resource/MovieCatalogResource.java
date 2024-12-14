package moviecatalog.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import moviecatalog.model.MovieCat;
import moviecatalog.model.Movie;

@Controller
@RequestMapping("/category")
public class MovieCatalogResource {
	public  List<MovieCat> cats = new ArrayList<>();
	@Autowired
    private RestTemplate rstc;
	@Autowired
	WebClient.Builder builder = WebClient.builder();

	public List<MovieCat>  getAllCategory(){
		if(cats.isEmpty()){
			ParameterizedTypeReference<List<Movie>> typeRef = new ParameterizedTypeReference<List<Movie>>() {
			};
			ResponseEntity<List<Movie>> response = rstc.exchange(
					"http://info-service/movie/all",
					HttpMethod.GET,
					null,
					typeRef);
			List<Movie> movieList = response.getBody();
			for(Movie m : movieList){
				MovieCat r = new MovieCat(m.getMid(),m.getRating(),m.getMname(),m.getCategory());
				cats.add(r);
			}
		}
           return cats;
	}

	@RequestMapping(value = "/{category}")
	public ResponseEntity<?> cataGory(@PathVariable String category){
		     this.getAllCategory();
			List<MovieCat> list = new ArrayList<>();
			for(MovieCat c : cats){
				if(c.getCategory().equalsIgnoreCase(category)){
					list.add(c);}}
		return new ResponseEntity<>(list, HttpStatus.OK);
}
	

@RequestMapping("/all")
public  ResponseEntity<?> allCategory(){
	this.getAllCategory();
	return new ResponseEntity<>(this.cats, HttpStatus.OK);

}		

	
}
