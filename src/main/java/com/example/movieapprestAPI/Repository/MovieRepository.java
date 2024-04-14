package com.example.movieapprestAPI.Repository;

import com.example.movieapprestAPI.Models.MovieModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends MongoRepository<MovieModel, String> {
    List<MovieModel> findByTitleContainingIgnoreCase(String title);
    List<MovieModel> findByFeatured(boolean featured);
}

