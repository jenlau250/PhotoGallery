package com.bignerdranch.android.photogallery;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;


//Similar to activity. It's a context that responds to intents
//For convention, addd newIntent(Context) method
//IntentService receives 1st command, fires up background thread and puts it on queue
//services each command by calling onHandleIntent(Intent)
//When no more commands left, service stops and is destroyed
//declare services in AndroidManifest
public class PollService extends IntentService {
    private static final String TAG = "PollService";
    public static Intent newIntent(Context context) {
        return new Intent(context, PollService.class);
    }
    public PollService() {
        super(TAG);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (!isNetworkAvailableandConnected()) {
            return;
        }
        Log.i(TAG, "Received an intent: " + intent);
    }

    private boolean isNetworkAvailableandConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        boolean isNetworkAvailable = cm.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable &&
                cm.getActiveNetworkInfo().isConnected();
        return isNetworkConnected;
    }



}
