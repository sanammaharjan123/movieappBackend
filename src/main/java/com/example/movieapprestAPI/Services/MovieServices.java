package com.example.movieapprestAPI.Services;

import com.example.movieapprestAPI.Models.MovieModel;
import com.example.movieapprestAPI.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServices {

    @Autowired
    private MovieRepository movieRepository;

    public void createMovie(MovieModel movie) {
        // Perform validation or business logic if needed
        movieRepository.save(movie);
    }

    public List<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<MovieModel> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<MovieModel> getFeaturedMovies() {
        return movieRepository.findByFeatured(true);
    }

    public MovieModel getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public void updateMovie(String movieId, MovieModel movie) {
        movie.setId(movieId);
        movieRepository.save(movie);
    }

    public boolean deleteMovieById(String movieId) {

        if (movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);
            return true;
        }else{
            return false;
        }

    }
}

