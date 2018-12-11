package com.academy.fundamentals.moviesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MoviesViewAdapter extends RecyclerView.Adapter<MoviesViewAdapter.ViewHolder>
{
    private LayoutInflater movieListInflat;
    private final List<MovieDataModel> movieDataSource;
    private OnMovieClickListener movieClickListener;

    public MoviesViewAdapter(Context context, List<MovieDataModel> data, OnMovieClickListener listener)
    {
        movieDataSource=data;
        movieClickListener=listener;
        movieListInflat=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount()
    {
        return movieDataSource.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View v=movieListInflat.inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,int position)
    {
        holder.bind(movieDataSource.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name,description;

        public ViewHolder(View v)
        {
            super(v);
            image=v.findViewById(R.id.item_movie_pic);
            name=v.findViewById(R.id.item_movie_name);
            description=v.findViewById(R.id.item_movie_description);
            v.setOnClickListener(this);
        }

        public void bind(MovieDataModel m)
        {
            image.setImageResource(m.getImageResourceId());
            name.setText(m.getName());
            description.setText(m.getOverview());
        }

        @Override
        public void onClick(View v)
        {
            if(movieClickListener==null) return;
            movieClickListener.onMovieListClick(getAdapterPosition());
        }
    }
}
