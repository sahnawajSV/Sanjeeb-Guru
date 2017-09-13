package com.example.movie.movieapp.services;

import com.example.movie.movieapp.model.MovieDetails;
import com.example.movie.movieapp.model.MovieModel;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by applemac on 12/09/17.
 */

public interface MovieAPiService {
    @GET("/movie/popular")
    void getMovieData(Callback<MovieModel.MovieResult> cb);

   @GET("/211672")
    void getMovieDetails(Callback<MovieDetails.MovieResult> cb);
}
