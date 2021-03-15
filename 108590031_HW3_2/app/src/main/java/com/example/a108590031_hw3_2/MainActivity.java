package com.example.a108590031_hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView myTextView;
    private Button btnToast,btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView)findViewById(R.id.textView);
        btnToast = (Button)findViewById(R.id.button);
        btnCount = (Button)findViewById(R.id.button2);
    }

    public void showToast(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Toast", mCount);
        startActivity(intent);
    }

    public void countUp(View view){
        mCount++;
        myTextView.setText(Integer.toString(mCount));
    }
}