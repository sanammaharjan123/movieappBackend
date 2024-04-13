package com.example.movieapprestAPI.Controller;

import com.example.movieapprestAPI.Models.TvShow;
import com.example.movieapprestAPI.Services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tvshows")
@Document(collection = "tvshows")
public class TvShowController {

    @Autowired
    private TvShowService tvShowService;

    // GET /api/tvshows
    @GetMapping
    public ResponseEntity<List<TvShow>> getAllTVShows() {
        List<TvShow> tvShows = tvShowService.getAllTVShows();
        return ResponseEntity.ok(tvShows);
    }



    // GET /api/tvshows/featured
    @GetMapping("/featured")
    public ResponseEntity<List<TvShow>> getFeaturedTVShows() {
        List<TvShow> tvShows = tvShowService.getFeaturedTVShows();
        return ResponseEntity.ok(tvShows);
    }

    // GET /api/tvshows/{tvShowId}
    @GetMapping("/{tvShowId}")
    public ResponseEntity<TvShow> getTVShowById(@PathVariable String tvShowId) {
        TvShow tvShow = tvShowService.getTVShowById(tvShowId);
        if (tvShow != null) {
            return ResponseEntity.ok(tvShow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

