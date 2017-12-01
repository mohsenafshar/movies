package ir.mohsenafshar.android.movies.movielist;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;
import ir.mohsenafshar.android.movies.network.RxService;

public class MovieListPresenter {

    private final RxService rxService;
    private final IMovieListView view;
    private CompositeDisposable disposables;

    public MovieListPresenter(RxService rxService, IMovieListView view) {
        this.rxService = rxService;
        this.view = view;
        this.disposables = new CompositeDisposable();
    }

    public void getMoviesList() {

        Disposable disposable = rxService.getCityList(
                new RxService.GetMovieListCallback() {
                    @Override
                    public void onSuccess(MovieResponse movieResponse) {
                        view.getMoviesListSuccess(movieResponse);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        view.onFailure(throwable.getMessage());
                    }
                });


        disposables.add(disposable);
    }

    public void onStop() {
        disposables.dispose();
    }
}
