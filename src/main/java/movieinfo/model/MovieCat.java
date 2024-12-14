package movieinfo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieCat {
private String name;
private Integer movieId;
private Integer rating;
private String category;
public MovieCat(Integer movieId , String name, String category) {
	super();
	this.movieId=movieId;
	this.name = name;
	this.rating = rating;
}
}
