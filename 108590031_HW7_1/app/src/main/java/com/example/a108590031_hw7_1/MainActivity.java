package com.example.a108590031_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView)findViewById(R.id.donut);
        img2 = (ImageView)findViewById(R.id.froyo);
        img3 = (ImageView)findViewById(R.id.icecream);
    }

    public void toDonut(View view){
        Intent intent = new Intent(this, donut.class);
        startActivity(intent);
    }

    public void toFroyo(View view){
        Intent intent = new Intent(this, froyo.class);
        startActivity(intent);
    }

    public void toIcecream(View view){
        Intent intent = new Intent(this, icecream.class);
        startActivity(intent);
    }
}