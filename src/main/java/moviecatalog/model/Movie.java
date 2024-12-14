package moviecatalog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Movie {
private Integer mid;
private String mname;
private String category;
private String country;
private Integer rating;
public Movie(Integer mid, String mname) {
	this.mid = mid;
	this.mname = mname;
}
public Movie() {
}
}
