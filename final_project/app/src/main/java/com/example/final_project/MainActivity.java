package com.example.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNextPage1(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/opinion/?chdtv");
        startActivity(intent);
    }

    public void startNextPage2(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/politic/?chdtv");
        startActivity(intent);
    }

    public void startNextPage3(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/life/?chdtv");
        startActivity(intent);
    }

    public void startNextPage4(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/star/?chdtv");
        startActivity(intent);
    }

    public void startNextPage5(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/technologynews/?chdtv");
        startActivity(intent);
    }

    public void startNextPage6(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/sports/?chdtv");
        startActivity(intent);
    }

    public void startNextPage7(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/hottopic/?chdtv");
        startActivity(intent);
    }

    public void startNextPage8(View view) {
        Intent intent = new Intent(this, nextPage.class);
        intent.putExtra("url", "https://www.chinatimes.com/world/?chdtv");
        startActivity(intent);
    }
}