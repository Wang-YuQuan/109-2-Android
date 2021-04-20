package com.example.a108590031_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LinkedList<String> mContainList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView containItemView;
        final WordListAdapter mAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views
         *                for the RecyclerView.
         */
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.title);
            containItemView=itemView.findViewById(R.id.content);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mWordList.
            String element = mWordList.get(mPosition);
            // Change the word in the mWordList.
            //mWordList.set(mPosition, "Clicked! " + element);
            if(mPosition == 0){
                Intent intent = new Intent(view.getContext(),one.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 1){
                Intent intent = new Intent(view.getContext(),two.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 2){
                Intent intent = new Intent(view.getContext(),three.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 3){
                Intent intent = new Intent(view.getContext(),four.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 4){
                Intent intent = new Intent(view.getContext(),five.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 5){
                Intent intent = new Intent(view.getContext(),six.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 6){
                Intent intent = new Intent(view.getContext(),seven.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 7){
                Intent intent = new Intent(view.getContext(),eight.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 8){
                Intent intent = new Intent(view.getContext(),nine.class);
                view.getContext().startActivity(intent);
            }
            else if(mPosition == 9){
                Intent intent = new Intent(view.getContext(),ten.class);
                view.getContext().startActivity(intent);
            }

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }

    public WordListAdapter(Context context, LinkedList<String> wordList, LinkedList<String> containList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.mContainList=containList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to
     * represent an item.
     *
     * This new ViewHolder should be constructed with a new View that can
     * represent the items of the given type. You can either create a new View
     * manually or inflate it from an XML layout file.
     *
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List). Since it will be reused to
     * display different items in the data set, it is a good idea to cache
     * references to sub views of the View to avoid unnecessary findViewById()
     * calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after
     *                 it is bound to an adapter position.
     * @param viewType The view type of the new View. @return A new ViewHolder
     *                 that holds a View of the given view type.
     */
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(
                R.layout.wordlist, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the ViewHolder.itemView to
     * reflect the item at the given position.
     *
     * @param holder   The ViewHolder which should be updated to represent
     *                 the contents of the item at the given position in the
     *                 data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        // Retrieve the data for that position.
        String mCurrent = mWordList.get(position);
        String mCurrent2=mContainList.get(position);
        // Add the data to the view holder.
        holder.wordItemView.setText(mCurrent);
        holder.containItemView.setText(mCurrent2);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}