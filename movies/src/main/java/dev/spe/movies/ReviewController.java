package dev.spe.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //any post to the above endpoint api-v1-movies
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        //this tells the framework to insert the request body into a map of string to string.
        return new ResponseEntity<Review>( reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);

    }
}
