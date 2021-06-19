package com.example.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Collections;

public class detail extends AppCompatActivity {
    private TextView mTextViewTitle, mTextViewBody;
    String body="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextViewTitle = (TextView)findViewById(R.id.detail_title);
        mTextViewBody = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        mTextViewTitle.setText(intent.getStringExtra("title"));
        new Thread((Runnable) () -> {
            try {
                Document doc = (Document) Jsoup.connect(intent.getStringExtra("url")).get();//解析html
                for(Element select : doc.select("div > p")){
                    if(select.text()!="") {
                        body += select.text() + "\n\n";
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewBody.setText(body);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.small:
                mTextViewBody.setTextSize(16);
                return true;
            case R.id.middle:
                mTextViewBody.setTextSize(20);
                return true;
            case R.id.big:
                mTextViewBody.setTextSize(24);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}