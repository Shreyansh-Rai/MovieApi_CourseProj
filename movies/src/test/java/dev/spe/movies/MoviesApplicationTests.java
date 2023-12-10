package dev.spe.movies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import dev.spe.movies.MovieRepository;
import dev.spe.movies.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MoviesApplicationTests {

	@Autowired
    private MovieController mc;
    @Autowired
    private MovieRepository mr;
    @Autowired
    private MovieService ms;

    @Test
    public void MoviesApplicationTests() {
        assert(true);
    }

    @Test
    public void testController (){
        assertEquals("test", mc.test());
    }
    @Test
    public void getAllMovies (){
        assertEquals(mr.findAll(), ms.allMovies());
    }

    @Test
    public void getSingleMovie()
    {
        String imdbId = "tt3915174";
        assertEquals(mr.findMovieByImdbId(imdbId), ms.singleMovie(imdbId));
    }

    @Test
    public void controllerTestMovie_1(){
        assertEquals(mc.getAllMovies(),new ResponseEntity<List<Movie>>(ms.allMovies(), HttpStatus.OK));
    }

    @Test
    public void controllerTestMovie_2(){
        String imdbId = "tt3915174";
        assertEquals(mc.getSingleMovie(imdbId),new ResponseEntity<Optional<Movie>>(ms.singleMovie(imdbId), HttpStatus.OK));
    }

}
