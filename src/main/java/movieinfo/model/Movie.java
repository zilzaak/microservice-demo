package movieinfo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Movie {
	private Integer mid;
	private Integer rating;
	private String mname;

	private String category;
	public Movie(Integer mid,Integer rating, String mname,String category) {
		this.mid = mid;
		this.rating=rating;
		this.mname = mname;
		this.category=category;
	}
}
