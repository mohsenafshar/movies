package ir.mohsenafshar.android.movies.movielist;

import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;

public interface IMovieListView {

    void onFailure(String appErrorMessage);

    void getMoviesListSuccess(MovieResponse movieResponse);
}
