package com.example.rynel.idbm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rynel.idbm.model.Genre;
import com.example.rynel.idbm.model.IMDbLookup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynel on 10/22/2017.
 */

public class MyItemListAdapter  extends RecyclerView.Adapter<MyItemListAdapter.ViewHolder> {

    private static final String TAG = "MyItemListAdapter";
    Context context;
    List<Genre> genreList = new ArrayList<>();

    public MyItemListAdapter(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @Override
    public MyItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate( R.layout.list_item, parent, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(MyItemListAdapter.ViewHolder holder, int position) {
        Genre genre = genreList.get( position );

        holder.genre = genre;

        Glide.with( context )
                .load( "https://image.tmdb.org/t/p/w640" + IMDbLookup.getPosterPath() )
                .into( holder.cover );

        holder.title.setText( genre.getName() );

        int score = (genre.getId());
        holder.rating.setText( score + "% (" + genre.getId() + " votes)" );
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cover;
        TextView title, releaseDate, rating;
        Genre genre;

        public ViewHolder(View itemView) {
            super(itemView);

            cover = itemView.findViewById( R.id.ivMovieCover );
            title = itemView.findViewById( R.id.tvMovieTitle );
            releaseDate = itemView.findViewById( R.id.tvMovieReleaseDate );
            rating = itemView.findViewById( R.id.tvMovieRating );

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked");

                    Toast.makeText( context, genre.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
