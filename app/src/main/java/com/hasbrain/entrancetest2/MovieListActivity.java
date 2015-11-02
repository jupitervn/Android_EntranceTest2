package com.hasbrain.entrancetest2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.hasbrain.entrancetest2.datastore.AssetBasedMovieDatastore;
import com.hasbrain.entrancetest2.datastore.MovieDatastore;
import com.hasbrain.entrancetest2.datastore.model.Movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        MovieDatastore movieDatastore = new AssetBasedMovieDatastore(this, "data.json", gson);
        movieDatastore.loadMovies(new MovieDatastore.MovieListRetrieverListener() {
            @Override
            public void onMovieListRetrieved(List<Movie> movieList) {
                //TODO: Display your list of movies here.
                Log.d("D.Vu", "movie list " + movieList.size());
            }
        });
    }

}
