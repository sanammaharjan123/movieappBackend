package com.example.movieapprestAPI.Services;

import com.example.movieapprestAPI.Models.TvShow;
import com.example.movieapprestAPI.Repository.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TvShowService {

    @Autowired
    private TvShowRepository tvShowRepository;

    public List<TvShow> getAllTVShows() {
        return tvShowRepository.findAll();
    }

    public List<TvShow> getFeaturedTVShows() {
        return tvShowRepository.findByFeatured(true);
    }



    public TvShow getTVShowById(String tvShowId) {
        return tvShowRepository.findById(tvShowId).orElse(null);
    }
}


