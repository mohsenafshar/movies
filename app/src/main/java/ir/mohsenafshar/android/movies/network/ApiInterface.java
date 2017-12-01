package ir.mohsenafshar.android.movies.network;

import io.reactivex.Observable;
import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @SuppressWarnings("unused")
    public static final String API_KEY = "a447989f2b34e1193b1194c6265c3d3f";

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieResponse> getAllMovies(@Query("page") String page, @Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMoviesByRx(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Observable<MovieResponse> getAllMoviesByRx(@Query("page") String page, @Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetailsByRx(@Path("id") int id, @Query("api_key") String apiKey);

}
