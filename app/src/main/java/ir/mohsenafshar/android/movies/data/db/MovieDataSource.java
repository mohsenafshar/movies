package ir.mohsenafshar.android.movies.data.db;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import ir.mohsenafshar.android.movies.data.pojo.Movie;

public class MovieDataSource {

    private static final String TAG = MovieDataSource.class.getCanonicalName();

    private Realm realm;

    public void open(){
        realm = Realm.getDefaultInstance();
    }

    public void close(){
        realm.close();
    }

    public void insertMovie(final Movie movie){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.insertOrUpdate(movie);
            }
        });
    }

    public List<Movie> getAllMovies(){
        return realm.where(Movie.class).findAll();
    }

}
