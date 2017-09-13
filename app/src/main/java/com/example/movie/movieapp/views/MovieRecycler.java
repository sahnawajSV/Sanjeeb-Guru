package com.example.movie.movieapp.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movie.movieapp.R;
import com.example.movie.movieapp.activities.MovieDetailsActivity;
import com.example.movie.movieapp.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by applemac on 12/09/17.
 */

public class MovieRecycler extends RecyclerView.Adapter<MovieHolder> {

    private List<MovieModel> _mMovieList;
    private LayoutInflater _mInflater;
    private Context _mContext;

    public MovieRecycler(Context context){
        this._mContext = context;
        this._mInflater = LayoutInflater.from(context);
        this._mMovieList = new ArrayList<>();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = _mInflater.inflate(R.layout.row_movie,parent,false);
        MovieHolder holder = new MovieHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        MovieModel movie = _mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.
        Picasso.with(_mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.posterImage);
        holder.titleText.setText(movie.getTitle());
        holder.descriptionText.setText(movie.getDescription());
        final int id = movie.get_movieId();
        holder.titleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(_mContext, MovieDetailsActivity.class);
                i.putExtra("id",String.valueOf(id));
                _mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (_mMovieList == null) ? 0 : _mMovieList.size();
    }

    public void setMovieList(List<MovieModel> movieList)
    {
        this._mMovieList.clear();
        this._mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();
    }
}
