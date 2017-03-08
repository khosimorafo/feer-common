package com.feerlaroc.libs;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by root on 2017/03/08.
 */

public class App extends Application {

    static App singleton;

    public static App getInstance(){
        return singleton;
    }

    public boolean checkIfHasNetwork()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean hasNetwork ()
    {
        return singleton.checkIfHasNetwork();
    }

}
