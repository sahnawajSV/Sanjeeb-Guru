package com.example.movie.movieapp.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movie.movieapp.R;

/**
 * Created by applemac on 12/09/17.
 */

public class MovieHolder extends RecyclerView.ViewHolder {

    public ImageView posterImage;
    public TextView titleText;
    public TextView descriptionText;

    public MovieHolder(View itemView) {
        super(itemView);
        /*
         * inflating the views of the recyclerview's row xml here
         */
        posterImage = (ImageView)itemView.findViewById(R.id.imageViewPoster);
        titleText = (TextView)itemView.findViewById(R.id.titleText);
        descriptionText = (TextView)itemView.findViewById(R.id.descriptionText);

    }

}
