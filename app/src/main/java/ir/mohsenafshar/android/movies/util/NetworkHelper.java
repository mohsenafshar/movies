package ir.mohsenafshar.android.movies.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkHelper {

    public static boolean hasNetwork(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm != null ? cm.getActiveNetworkInfo() : null;

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}