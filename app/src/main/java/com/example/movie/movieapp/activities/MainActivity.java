package com.example.movie.movieapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.movie.movieapp.R;
import com.example.movie.movieapp.model.MovieModel;
import com.example.movie.movieapp.services.MovieAPiService;
import com.example.movie.movieapp.views.MovieRecycler;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView _recyclerView;
    private MovieRecycler _movieRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        _recyclerView.setLayoutManager(new LinearLayoutManager(this));
        _movieRecycler = new MovieRecycler(this);
        _recyclerView.setAdapter(_movieRecycler);


        //retrofit call to get the movie data

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.themoviedb.org/3/")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", getResources().getString(R.string.apiKey));
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MovieAPiService service = restAdapter.create(MovieAPiService.class);
        service.getMovieData(new Callback<MovieModel.MovieResult>() {
            @Override
            public void success(MovieModel.MovieResult movieResult, Response response) {
                _movieRecycler.setMovieList(movieResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
//        _recyclerView.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, _recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override public void onItemClick(View view, int position) {
//                        Log.d("tag",String.valueOf(position));
//
//                    }
//
//                    @Override public void onLongItemClick(View view, int position) {
//                        // do whatever
//                    }
//                }
//                ));
//        List<MovieModel> movies = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            movies.add(new MovieModel());
//        }
       // _movieRecycler.setMovieList(movies);
    }
}
