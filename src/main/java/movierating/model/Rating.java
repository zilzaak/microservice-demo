package movierating.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Rating {
private Integer mid;
private Integer rating;
private String movieName;
private String category;
public Rating(Integer mid, Integer rating,String movieName,String category) {
	super();
	this.mid = mid;
	this.rating = rating;
	this.movieName=movieName;
	this.category=category;

}
}
