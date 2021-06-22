package com.example.final_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class detail extends AppCompatActivity {
    private TextView mTextViewTitle, mTextViewBody;
    private ImageView imageView;
    String body="";
    String mPictureSrc="";
    private Bitmap mbitmap=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextViewTitle = (TextView)findViewById(R.id.detail_title);
        mTextViewBody = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.picture);
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
                for(Element select : doc.getElementsByTag("img")){
                    mPictureSrc += select.attr("abs:src");
                    break;
                }
                if(mPictureSrc!="") {
                    mbitmap = returnBitMap(mPictureSrc);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewBody.setText(body);
                        if(mbitmap!=null) {
                            imageView.setImageBitmap(mbitmap);
                        }
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

    public Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}