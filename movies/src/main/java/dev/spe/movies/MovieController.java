package dev.spe.movies;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//api layer that uses the service to generate output depending on endpoint hit.
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/movies")
public class MovieController {
    private static final Logger logger =
            LogManager.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        logger.info("Get all movies executed");
        logger.debug("Get all movies working");
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}") //this could be anything in the {} but to be consistent.
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId)
    {
        String log = "Single Movie queried : imdbId " + imdbId;
        logger.info(log);
        logger.warn("Single query called return entity could be an optional value");
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
    public String test()
    {
        return "test";
    }
}
