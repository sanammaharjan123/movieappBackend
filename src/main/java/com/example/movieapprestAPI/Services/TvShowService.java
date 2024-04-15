package com.example.movieapprestAPI.Services;

import com.example.movieapprestAPI.Models.TvShow;
import com.example.movieapprestAPI.Repository.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

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

    public Optional<TvShow> updateTVShow(String id, TvShow tvShowDetails) {
        Optional<TvShow> tvShowOptional = tvShowRepository.findById(id);
        if(tvShowOptional.isPresent()) {
            TvShow tvShowToUpdate = tvShowOptional.get();
            tvShowToUpdate.setTitle(tvShowDetails.getTitle() != null ? tvShowDetails.getTitle() : tvShowToUpdate.getTitle());
            tvShowToUpdate.setRentPrice(tvShowDetails.getRentPrice() != null ? tvShowDetails.getRentPrice() : tvShowToUpdate.getRentPrice());

            tvShowRepository.save(tvShowToUpdate);
            return Optional.of(tvShowToUpdate);
        } else {
            return Optional.empty();
        }
    }
    public boolean deleteTvShowById(String TvShowId) {

        if (tvShowRepository.existsById(TvShowId)) {
            tvShowRepository.deleteById(TvShowId);
            return true;
        }else{
            return false;
        }

    }
    public TvShow addTVShow(TvShow tvShow) {
        return tvShowRepository.save(tvShow);
    }
//    public boolean deleteTvShow(String TvShowId) {
//
//        if (TvShowRepository.existsById(TvShowId)) {
//            TvShowRepository.deleteById(TvShowId);
//            return true;
//        }else{
//            return false;
//        }
}


