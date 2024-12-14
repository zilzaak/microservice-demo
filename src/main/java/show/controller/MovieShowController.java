package show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import show.MovieShowApp;
import show.model.MovieShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/show")
public class MovieShowController {
    public static final List<MovieShow>  shows = Arrays.asList(
          new MovieShow(1, LocalDate.parse("2024-05-12"),800,"Dhaka","Start Cineplex",41),
            new MovieShow(2, LocalDate.parse("2024-12-01"),500,"Cumilla","Start Cineplex",35),
            new MovieShow(3, LocalDate.parse("2024-12-05"),500,"Sylhet","Start Cineplex",16),
            new MovieShow(4, LocalDate.parse("2024-12-02"),600,"Pabna","Start Cineplex",47),
            new MovieShow(5, LocalDate.parse("2024-10-02"),650,"Jessore","Start Cineplex",52),
            new MovieShow(6, LocalDate.parse("2024-08-12"),500,"Rajshahi","Start Cineplex",39),
            new MovieShow(7, LocalDate.parse("2024-09-10"),700,"Chittagong","Start Cineplex",31),
            new MovieShow(8, LocalDate.parse("2024-09-20"),900,"Khulna","Start Cineplex",10),
            new MovieShow(9, LocalDate.parse("2024-05-18"),650,"Rangpur","Start Cineplex",10),
            new MovieShow(10, LocalDate.parse("2024-07-19"),500,"Chandpur","Start Cineplex",8),
            new MovieShow(11, LocalDate.parse("2024-09-08"),650,"Barishal","Start Cineplex",50),
            new MovieShow(12, LocalDate.parse("2024-10-05"),720,"Gazipur","Start Cineplex",12));


    @Autowired
    private RestTemplate rstc;
    @Autowired
    WebClient.Builder builder = WebClient.builder();

    @RequestMapping("/{movieId}")
    public ResponseEntity<?> getShow(@PathVariable Integer movieId){
               for(MovieShow s : shows){
                   if(s.getMid().equals(movieId)){
                     return new ResponseEntity<>(s,HttpStatus.OK);
                   }
               }

        return null;
    }




}
