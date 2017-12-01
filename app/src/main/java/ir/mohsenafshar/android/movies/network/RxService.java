package ir.mohsenafshar.android.movies.network;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;

public class RxService {
    @SuppressWarnings("unused")
    public static final String API_KEY = "a447989f2b34e1193b1194c6265c3d3f";

    private ApiInterface apiInterface;

    public RxService(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Disposable getCityList(final GetMovieListCallback callback) {

        return apiInterface.getAllMoviesByRx("1", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Exception {
                        callback.onSuccess(movieResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(throwable);
                    }
                });
    }

    public interface GetMovieListCallback {
        void onSuccess(MovieResponse movieResponse);

        void onError(Throwable throwable);
    }
}
