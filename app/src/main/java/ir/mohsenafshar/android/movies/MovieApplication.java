package ir.mohsenafshar.android.movies;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.mohsenafshar.android.movies.network.DaggerDiComponent;
import ir.mohsenafshar.android.movies.network.DiComponent;
import ir.mohsenafshar.android.movies.network.NetworkModule;


public abstract class MovieApplication extends AppCompatActivity {
    DiComponent component;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component = DaggerDiComponent.builder().networkModule(new NetworkModule(null)).build();
    }

    public DiComponent getDiComponent(){
        return component;
    }
}
