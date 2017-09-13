package com.example.movie.movieapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.movieapp.R;
import com.example.movie.movieapp.model.MovieDetails;
import com.example.movie.movieapp.model.MovieModel;
import com.example.movie.movieapp.services.MovieAPiService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by applemac on 12/09/17.
 */

public class MovieDetailsActivity extends AppCompatActivity {

    private Menu _menu;
    private int _movieID;
    private TextView _movieTitle;
    private TextView _movieDescription;
    private TextView _movieRatings;
    private ImageView _imageView;
    List<MovieDetails> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        _movieTitle = (TextView)findViewById(R.id.titleText);
        _movieDescription = (TextView)findViewById(R.id.descriptionText);
        _movieRatings = (TextView)findViewById(R.id.ratingText);
        _imageView = (ImageView)findViewById(R.id.imageViewPoster);
        list = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();

        if(bundle!= null)
        {
            String movie= bundle.getString("id");
            _movieID = Integer.parseInt(movie);
        }


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.themoviedb.org/3/movie/")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", getResources().getString(R.string.apiKey));
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MovieAPiService service = restAdapter.create(MovieAPiService.class);
        service.getMovieDetails(new Callback<MovieDetails.MovieResult>() {

            @Override
            public void success(MovieDetails.MovieResult movieResult, Response response) {
//                Log.d("tag",response.toString());
//
//                list.addAll(movieResult.getResults());
//                MovieDetails details = list.get(0);
//                _movieTitle.setText(details.get_movieTitle());
//
////                try {
////                    JSONObject obj = new JSONObject(response.toString());
////                    _movieTitle.setText(obj.getString("original_title"));
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this._menu = menu;
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        hideOption(R.id.action_info);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = _menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = _menu.findItem(id);
        item.setVisible(true);
    }
}
