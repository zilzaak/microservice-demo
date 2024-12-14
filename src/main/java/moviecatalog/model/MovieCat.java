package moviecatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieCat {
private String name;
private Integer movieId;
private Integer rating;
private String category;
public MovieCat(Integer movieId ,Integer rating , String name, String category) {
	super();
	this.movieId=movieId;
	this.rating=rating;
	this.name = name;
	this.category = category;
}
}
