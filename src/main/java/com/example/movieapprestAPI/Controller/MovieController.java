package com.example.movieapprestAPI.Controller;

import com.example.movieapprestAPI.Models.MovieModel;
import com.example.movieapprestAPI.Services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieServices movieService;

    // POST /api/movies
    @PostMapping
    public ResponseEntity<String> createMovie(@RequestBody MovieModel movie) {
        try {
            movieService.createMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body("Movie created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create movie");
        }
    }

    // GET /api/movies
    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        List<MovieModel> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // GET /api/movies/search?title={title}
    @GetMapping("/search")
    public ResponseEntity<List<MovieModel>> searchMoviesByTitle(@RequestParam String title) {
        List<MovieModel> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }



    // GET /api/movies/featured
    @GetMapping("/featured")
    public ResponseEntity<List<MovieModel>> getFeaturedMovies() {
        List<MovieModel> movies = movieService.getFeaturedMovies();
        return ResponseEntity.ok(movies);
    }

    // GET /api/movies/{movieId}
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable String movieId) {
        MovieModel movie = movieService.getMovieById(movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /api/movies/{movieId}
    @PutMapping("/{movieId}")
    public ResponseEntity<String> updateMovie(@PathVariable String movieId, @RequestBody MovieModel movie) {
        try {
            movieService.updateMovie(movieId, movie);
            return ResponseEntity.ok("Movie updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update movie");
        }
    }

    // DELETE /api/movies/{movieId}
    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        try {
            movieService.deleteMovie(movieId);
            return ResponseEntity.ok("Movie deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete movie");
        }
    }
}

