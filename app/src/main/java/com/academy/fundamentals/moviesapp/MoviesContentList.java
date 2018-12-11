package com.academy.fundamentals.moviesapp;

import java.util.ArrayList;

public class MoviesContentList
{
    public static final ArrayList<MovieDataModel> MOVIES = new ArrayList<>();

    public static void clear() {
        MOVIES.clear();
    }

    public static void addMovie(MovieDataModel movie) {
        MOVIES.add(movie);
    }
}
