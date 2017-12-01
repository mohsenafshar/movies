package ir.mohsenafshar.android.movies.movielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import ir.mohsenafshar.android.movies.MovieApplication;
import ir.mohsenafshar.android.movies.R;
import ir.mohsenafshar.android.movies.data.pojo.Movie;
import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;
import ir.mohsenafshar.android.movies.detailsmovie.DetailActivity;
import ir.mohsenafshar.android.movies.network.RxService;

public class MovieListActivity extends MovieApplication implements IMovieListView {

    private RecyclerView recyclerView;
    @Inject
    public RxService service;
    public static final  String MOVIE = "MOVIE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDiComponent().inject(this);

        renderView();
        init();

        MovieListPresenter presenter = new MovieListPresenter(service, this);
        presenter.getMoviesList();
    }

    private void renderView() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Toast.makeText(this, "Failed to fetch movies.", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, appErrorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMoviesListSuccess(MovieResponse movieResponse) {
        List<Movie> movies = movieResponse.getResults();
        MovieListAdapter adapter = new MovieListAdapter(this, movieResponse,
                new MovieListAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(Movie movie) {
                        Toast.makeText(MovieListActivity.this, movie.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MovieListActivity.this, DetailActivity.class);
                        intent.putExtra(MOVIE, movie);
                        //intent.putParcelableArrayListExtra("MOVIE", movie);
                        startActivity(intent);
                    }
                });

        recyclerView.setAdapter(adapter);
    }

}
