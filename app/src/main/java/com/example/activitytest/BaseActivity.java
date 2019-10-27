package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Create_BaseActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy_BaseActivity",getClass().getSimpleName());
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start_BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop_BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume_BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause_BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Restart_BaseActivity",getClass().getSimpleName());
    }
}

class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
