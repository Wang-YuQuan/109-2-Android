package com.example.a108590031_hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView myTextView;
    private int myIntent=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        myIntent = intent.getIntExtra("Toast",0);
        myTextView = (TextView)findViewById(R.id.textView2);
        if(myTextView != null) {
            myTextView.setText("Hello Toast"+"\n"+ myIntent);
        }
    }
}