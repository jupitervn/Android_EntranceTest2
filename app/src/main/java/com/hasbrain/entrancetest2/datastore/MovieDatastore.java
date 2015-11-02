package com.hasbrain.entrancetest2.datastore;


import com.hasbrain.entrancetest2.datastore.model.Movie;

import java.util.List;

/**
 * Created by Jupiter (vu.cao.duy@gmail.com) on 11/2/15.
 */
public interface MovieDatastore {
    interface MovieListRetrieverListener {
        void onMovieListRetrieved(List<Movie> movieList);
    }
    void loadMovies(MovieListRetrieverListener onMovieListRetrieverListener);
}
