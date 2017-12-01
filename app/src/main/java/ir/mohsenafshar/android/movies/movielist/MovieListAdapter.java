package ir.mohsenafshar.android.movies.movielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.mohsenafshar.android.movies.R;
import ir.mohsenafshar.android.movies.data.pojo.Movie;
import ir.mohsenafshar.android.movies.data.pojo.MovieResponse;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private MovieResponse movieResponses;

    public MovieListAdapter(Context context, MovieResponse movieResponses, OnItemClickListener listener) {
        this.listener = listener;
        this.movieResponses = movieResponses;
        this.context = context;
    }

    private Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.click(movieResponses.getResults().get(position), listener);
        holder.tv.setText(movieResponses.getResults().get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movieResponses.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv_item);
        }

        public void click(final Movie movie, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(movie);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(Movie movie);
    }


}
