package ir.mohsenafshar.android.movies.network;

import javax.inject.Singleton;

import dagger.Component;
import ir.mohsenafshar.android.movies.movielist.MovieListActivity;

@Singleton
@Component(modules = {NetworkModule.class})
public interface DiComponent {
    void inject(MovieListActivity movieListActivity);
}
