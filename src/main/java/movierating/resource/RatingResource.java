package movierating.resource;

import movierating.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movierating.model.Rating;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/rating")
public class RatingResource {
    //String mid, Integer rating,String movieName,String category)

    @Autowired
    private RestTemplate rt;

    public  List<Rating> ratings = new ArrayList<>();

   public List<Rating> getAllRatings(){
       if (ratings.isEmpty()) {
           ParameterizedTypeReference<List<Movie>> typeRef = new ParameterizedTypeReference<List<Movie>>() {
           };
           ResponseEntity<List<Movie>> response = rt.exchange(
                   "http://info-service/movie/all",
                   HttpMethod.GET,
                   null,
                   typeRef
           );
           List<Movie> movieList = response.getBody();
           if (movieList != null) {
               for (Movie m : movieList) {
                   Rating r = new Rating(m.getMid(), m.getRating(), m.getMname(), m.getCategory());
                   ratings.add(r);
               }
           }
       }
       return ratings;
    }

	
@RequestMapping("/{mid}")
public ResponseEntity<?> mrating(@PathVariable Integer mid) {
    this.getAllRatings();
	for(Rating r : this.ratings){
        if(mid.equals(r.getMid())){
            return new ResponseEntity<>(r, HttpStatus.OK) ;
        }
    }
  return null;
}

@RequestMapping("/all")
    public ResponseEntity<?> allRatings(){
         this.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK) ;
   }

	
}
