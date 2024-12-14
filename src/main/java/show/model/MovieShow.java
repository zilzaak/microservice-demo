package show.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@NoArgsConstructor
public class MovieShow {

    private Integer mid;
    private LocalDate releaseDate;
    private Integer ticketPrice;
    private String location;
    private  String hallName;
    private Integer avlTicket;

    public MovieShow(Integer mid,
                     LocalDate releaseDate,
                     Integer ticketPrice,
                     String location,
                     String hallName,
                     Integer avlTicket) {
        this.mid = mid;
        this.releaseDate = releaseDate;
        this.ticketPrice = ticketPrice;
        this.location = location;
        this.hallName = hallName;
        this.avlTicket = avlTicket;
    }
}
