package com.quadible.activitycounter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;


public class ActivityCounter {

    private static ActivityCounter sInstance;

    private static ActivityCounterLifecycleCallbacks mCallback =
            new ActivityCounterLifecycleCallbacks();

    private ActivityCounter() {
    }

    public static ActivityCounter getInstance() {
        if (sInstance == null) sInstance = new ActivityCounter();
        return sInstance;
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(mCallback);
    }

    public int getCount() {
        return mCallback.mActivities;
    }

    private static class ActivityCounterLifecycleCallbacks
            implements Application.ActivityLifecycleCallbacks {

        private static final String BUNDLE_KEY_ACTIVITIES = "numberOfActivities";

        private int mActivities = 0;

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (mActivities == 0 && savedInstanceState != null) {
                mActivities = savedInstanceState.getInt(BUNDLE_KEY_ACTIVITIES);
            } else if (savedInstanceState == null) {
                mActivities++;
            }
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (activity.isFinishing()) {
                mActivities--;
            }
        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            outState.putInt(BUNDLE_KEY_ACTIVITIES, mActivities);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }

    }

}