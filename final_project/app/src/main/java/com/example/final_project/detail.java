package com.example.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Collections;

public class detail extends AppCompatActivity {
    private TextView mTextView;
    String body="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextView = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        new Thread((Runnable) () -> {
            try {
                Document doc = (Document) Jsoup.connect(intent.getStringExtra("url")).get();//解析html
                for(Element select : doc.select("div > p")){
                    if(select.text()!="") {
                        body += select.text() + "\n\n\n";
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextView.setText(body);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}