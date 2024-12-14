package moviecatalog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Rating {
private String mid;
private Integer rating;

public Rating(String mid, Integer rating) {
	super();
	this.mid = mid;
	this.rating = rating;
}
public Rating() {
	super();
}
}
