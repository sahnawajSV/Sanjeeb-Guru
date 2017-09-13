package com.example.movie.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by applemac on 12/09/17.
 */

public class MovieModel {

    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";

    @SerializedName("title")
    private String _title;

    public int get_movieId() {
        return _movieId;
    }

    public void set_movieId(int _movieId) {
        this._movieId = _movieId;
    }

    @SerializedName("id")
    private int _movieId;

    @SerializedName("poster_path")
    private String _poster;

    @SerializedName("overview")
    private String _description;

    @SerializedName("backdrop_path")
    private String _backdrop;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getPoster() {
        return TMDB_IMAGE_PATH +_poster;
    }

    public void setPoster(String poster) {
        this._poster = poster;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public String getBackdrop() {
        return TMDB_IMAGE_PATH  +_backdrop;
    }

    public void setBackdrop(String backdrop) {
        this._backdrop = backdrop;
    }
    public static class MovieResult {
        private List<MovieModel> results;

        public List<MovieModel> getResults() {
            return results;
        }
    }
}
