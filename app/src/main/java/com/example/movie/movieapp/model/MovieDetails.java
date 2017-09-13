package com.example.movie.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by applemac on 12/09/17.
 */

public class MovieDetails {

    @SerializedName("original_title")
    private String _movieTitle;

    @SerializedName("vote_average")
    private String _movieRatings;

    @SerializedName("overview")
    private String _movieDescription;

    public String get_movieTitle() {
        return _movieTitle;
    }

    public void set_movieTitle(String _movieTitle) {
        this._movieTitle = _movieTitle;
    }

    public String get_movieRatings() {
        return _movieRatings;
    }

    public void set_movieRatings(String _movieRatings) {
        this._movieRatings = _movieRatings;
    }

    public String get_movieDescription() {
        return _movieDescription;
    }

    public void set_movieDescription(String _movieDescription) {
        this._movieDescription = _movieDescription;
    }

    public static class MovieResult {
        private List<MovieDetails> results;

        public List<MovieDetails> getResults() {
            return results;
        }
    }
}
