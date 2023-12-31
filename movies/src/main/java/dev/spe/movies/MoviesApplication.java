package dev.spe.movies;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoviesApplication {
	private static final Logger logger =
			LogManager.getLogger(MoviesApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot()
	{
		logger.info("/ entered");
		logger.debug("Endpoint working");
		return "Hello World!";
	}
}
