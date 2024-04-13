package com.example.movieapprestAPI.Repository;

import com.example.movieapprestAPI.Models.MovieModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovieRepository extends MongoRepository<MovieModel, String> {
    List<MovieModel> findByTitleContainingIgnoreCase(String title);
    List<MovieModel> findByFeatured(boolean featured);
}

