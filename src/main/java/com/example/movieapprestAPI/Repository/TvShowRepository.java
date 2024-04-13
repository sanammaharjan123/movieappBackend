package com.example.movieapprestAPI.Repository;

import com.example.movieapprestAPI.Models.TvShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TvShowRepository extends MongoRepository<TvShow, String> {
    List<TvShow> findByFeatured(boolean featured);
}

