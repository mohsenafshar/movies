package ir.mohsenafshar.android.movies.detailsmovie;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.RequestBuilder;
import com.squareup.picasso.Picasso;

import ir.mohsenafshar.android.movies.R;
import ir.mohsenafshar.android.movies.data.pojo.Movie;
import ir.mohsenafshar.android.movies.movielist.MovieListActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w780/";
    private Movie movie;

    //Resources View
    private ImageView movieImageView;
    private ImageView starImageView;
    private TextView movieTitleView;
    private TextView movieExplanatoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movieImageView = findViewById(R.id.iv_movie);
        starImageView = findViewById(R.id.iv_star);
        movieTitleView = findViewById(R.id.tv_name);
        movieExplanatoryView = findViewById(R.id.tv_explain);

        Intent intent = getIntent();
        if(intent.hasExtra(MovieListActivity.MOVIE))
            movie = getIntent().getExtras().getParcelable(MovieListActivity.MOVIE);

        if (movie != null) {
            Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: " + movie);
        }

        setData();
    }

    private void setData() {
        Picasso.with(this)
                .load(BASE_IMAGE_URL + movie.getPosterPath())
                .fit()
                .placeholder(R.drawable.alert)
                .error(R.drawable.ic_dialog_alert)
                .into(movieImageView);

        movieTitleView.setText(movie.getTitle());
        movieExplanatoryView.setText(movie.getOverview());
    }
}
