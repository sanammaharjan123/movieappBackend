package com.example.movieapprestAPI.Repository;

import com.example.movieapprestAPI.Models.TvShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TvShowRepository extends MongoRepository<TvShow, String> {
    List<TvShow> findAll();
    List<TvShow> findByFeatured(boolean featured);

    List<TvShow> findByTitleContaining(String title);
}

