package com.quadible.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.quadible.activitycounter.ActivityCounter;

public class MainActivity extends AppCompatActivity {

    private TextView mActivityCounter;

    private Button mNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityCounter = findViewById(R.id.txtActivityCounter);

        int activities = ActivityCounter.getInstance().getCount();
        String label = getString(R.string.label_num_of_activities) + activities;
        mActivityCounter.setText(label);

        mNewActivity = findViewById(R.id.btnNewActivity);
        mNewActivity.setOnClickListener(openNew);
    }

    private final View.OnClickListener openNew = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };
}
