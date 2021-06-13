package com.example.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class nextPage extends AppCompatActivity {
    private String mUrl;
    private String Title="",subTitle="";
    private String[] s1;
    private String[] s2;
    private ArrayList<WebInfo> mWebInfo;
    private RecyclerView mRecyclerView;
    private WebAdapter mAdapter;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mWebInfo = new ArrayList<>();
        new Thread((Runnable) () -> {
            try {
                Document doc = (Document) Jsoup.connect(mUrl).get();//解析html
                for(Element select : doc.select("h3")){
                    if(i>=2) {
                        Title += select.text() + "\n\n\n";
                    }
                    if(i>20){
                        break;
                    }
                    i++;
                }
                i = 0;
                for(Element select : doc.getElementsByClass("intro")){
                    subTitle += select.text()+"\n\n\n";
                    if(i>18){
                        break;
                    }
                    i++;
                }
                s1 = Title.split("\n\n\n");
                s2 = subTitle.split("\n\n\n");
                //Log.d("apple", s1[0]+"\n"+s2[0]);


                // 實作recycler view
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        mAdapter = new WebAdapter(getApplicationContext(), mWebInfo);
                        mRecyclerView.setAdapter(mAdapter);
                        mAdapter.notifyDataSetChanged();
                        initializeData();

                        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                            /**
                             * Defines the drag and drop functionality.
                             *
                             * @param recyclerView The RecyclerView that contains the list items
                             * @param viewHolder The SportsViewHolder that is being moved
                             * @param target The SportsViewHolder that you are switching the
                             *               original one with.
                             * @return true if the item was moved, false otherwise
                             */
                            @Override
                            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                                // Get the from and to positions.
                                int from = viewHolder.getAdapterPosition();
                                int to = target.getAdapterPosition();

                                // Swap the items and notify the adapter.
                                Collections.swap(mWebInfo, from, to);
                                mAdapter.notifyItemMoved(from, to);
                                return true;
                            }

                            /**
                             * Defines the swipe to dismiss functionality.
                             *
                             * @param viewHolder The viewholder being swiped.
                             * @param direction The direction it is swiped in.
                             */
                            @Override
                            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                                // Remove the item from the dataset.
                                mWebInfo.remove(viewHolder.getAdapterPosition());
                                // Notify the adapter.
                                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                            }
                        });

                        // Attach the helper to the RecyclerView.
                        helper.attachToRecyclerView(mRecyclerView);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void initializeData() {
        // Clear the existing data (to avoid duplication).
        mWebInfo.clear();

        // Create the ArrayList of Sports objects with the titles and
        // information about each sport
        for (int x = 0; x < s1.length; x++) {
            mWebInfo.add(new WebInfo(s1[x], s2[x]+"..."));
        }

        // Recycle the typed array.
        //sportsImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }
}