package com.example.movieapprestAPI.Controller;

import com.example.movieapprestAPI.Models.TvShow;
import com.example.movieapprestAPI.Services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<TvShow> getTVShowById(@PathVariable String tvShowId) {
        TvShow tvShow = tvShowService.getTVShowById(tvShowId);
        if (tvShow != null) {
            return ResponseEntity.ok(tvShow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTVShow(@PathVariable String id, @RequestBody TvShow tvShow) {
        Optional<TvShow> updatedTVShow = tvShowService.updateTVShow(id, tvShow);
        if(updatedTVShow.isPresent()) {
            return ResponseEntity.ok(updatedTVShow.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TV Show not found with ID: " + id);
        }
    }
    @PostMapping
    public ResponseEntity<TvShow> addTVShow(@RequestBody TvShow tvShow) {
        TvShow newTVShow = tvShowService.addTVShow(tvShow);
        return new ResponseEntity<>(newTVShow, HttpStatus.CREATED);
    }
//    @DeleteMapping("/{TvShowId}")
//    public ResponseEntity<String> deleteTVShow(@PathVariable String TvShowId) {
//        try {
//            TvShowService.deleteTvShow(TvShowId);
//            return ResponseEntity.ok("TvShow deleted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete TvShow");
//        }
//    }
}

