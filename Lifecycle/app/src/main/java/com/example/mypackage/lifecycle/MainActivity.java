package com.example.mypackage.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Log.v("MainActivity", getString(R.string.create_lifecycle_state));
        textView.setText(getString(R.string.create_lifecycle_state));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", getString(R.string.start_lifecycle_state));
        textView.setText(getString(R.string.start_lifecycle_state));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", getString(R.string.resume_lifecycle_state));
        textView.setText(getString(R.string.resume_lifecycle_state));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", getString(R.string.pause_lifecycle_state));
        textView.setText(getString(R.string.pause_lifecycle_state));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", getString(R.string.stop_lifecycle_state));
        textView.setText(getString(R.string.stop_lifecycle_state));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", getString(R.string.destroy_lifecycle_state));
        textView.setText(getString(R.string.destroy_lifecycle_state));
    }
}
