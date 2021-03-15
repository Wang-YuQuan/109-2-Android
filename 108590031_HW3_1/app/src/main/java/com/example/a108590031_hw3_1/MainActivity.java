package com.example.a108590031_hw3_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int show_Random = 0;
    private TextView mShowCount;
    private Button btnRabdom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView5);
        btnRabdom = (Button)findViewById(R.id.button);
    }

    public void showRandom(View view){
        Random r = new Random();
        show_Random = r.nextInt(5);
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(show_Random));
    }
}