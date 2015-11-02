package com.hasbrain.entrancetest2.datastore;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.hasbrain.entrancetest2.datastore.model.Movie;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Jupiter (vu.cao.duy@gmail.com) on 11/2/15.
 */
public class AssetBasedMovieDatastore implements MovieDatastore {

    private Context context;
    private String dataFilename;
    private Gson gson;

    public AssetBasedMovieDatastore(Context context, String dataFilename, Gson gson) {
        this.context = context;
        this.dataFilename = dataFilename;
        this.gson = gson;
    }


    @Override
    public void loadMovies(MovieListRetrieverListener onMovieListRetrieverListener) {
        if (onMovieListRetrieverListener != null) {
            Type type = new TypeToken<List<Movie>>(){}.getType();
            InputStream is = null;
            try {
                is = context.getAssets().open(dataFilename);
                List<Movie> posts = gson.fromJson(new InputStreamReader(is), type);
                onMovieListRetrieverListener.onMovieListRetrieved(posts);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
