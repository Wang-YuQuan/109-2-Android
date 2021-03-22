package com.example.a108590031_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private int mcount = 0;
    private EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.Edittext1);
        tv = (TextView) findViewById(R.id.m);
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            mcount = Integer.parseInt(count);
            if (tv != null)
                tv.setText(count);
        }
        Log.i("MainActivity", "onCreate");
    }

    public void Count(View view){
        mcount++;
        tv.setText(Integer.toString(mcount));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("count", String.valueOf(tv.getText()));
        Log.i("MainActivity", "onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // The activity is between stopped and started.
        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible
        // it is now "resumed"
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus
        // this activity is about to be "paused"
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible
        // it is now "stopped"
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.i("MainActivity", "onDestroy");
    }
}