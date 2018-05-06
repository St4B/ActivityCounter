package com.quadible.app;

import android.app.Application;

import com.quadible.activitycounter.ActivityCounter;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActivityCounter.getInstance().register(this);
    }
}
