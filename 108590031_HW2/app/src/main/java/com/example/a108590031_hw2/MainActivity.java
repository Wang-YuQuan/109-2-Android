package com.example.a108590031_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0,cntToast=0,cntCountUp=0;
    private TextView mShowCount;
    private Button btnToast,btnZero,btnCountUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView);
        btnToast = (Button) findViewById(R.id.button5);
        btnZero = (Button) findViewById(R.id.button);
        btnCountUp = (Button) findViewById(R.id.button4);
        btnZero.setEnabled(false);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.button5,
                Toast.LENGTH_SHORT);
        toast.show();
        if(cntToast%2==1){
            btnToast.setBackgroundColor(Color.GREEN);
        }
        else{
            btnToast.setBackgroundColor(0xFF6200EE);
        }
        cntToast++;
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if(cntCountUp%2==1){
            btnCountUp.setBackgroundColor(Color.RED);
        }
        else{
            btnCountUp.setBackgroundColor(0xFF007FFF);
        }
        cntCountUp++;
        btnZero.setBackgroundColor(0xFF4F2F4F);
        btnZero.setEnabled(true);
    }

    public void countZero(View view) {
        mCount = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        btnZero.setEnabled(false);
        btnZero.setBackgroundColor(Color.GRAY);
    }
}