package com.example.final_project;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.security.keystore.WrappedKeyEntry;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class WebAdapter extends RecyclerView.Adapter<WebAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<WebInfo> Information;
    private Context mContext;

    WebAdapter(Context context, ArrayList<WebInfo> input) {
        this.mContext = context;
        this.Information = input;
    }

    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public WebAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(WebAdapter.ViewHolder holder, int position) {
        WebInfo current = Information.get(position);

        // Populate the textviews with data.
        holder.bindTo(current);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return Information.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private  TextView mdatetime;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.article);
            mdatetime = itemView.findViewById(R.id.datetime);
            //mSportsImage = itemView.findViewById(sportsImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(WebInfo current){
            // Populate the textviews with data.
            mTitleText.setText(current.getTitle());
            mInfoText.setText(current.getInfo());
            mdatetime.setText(current.getDatetime());
            // Load the images into the ImageView using the Glide library.
            //Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
            //mSportsImage.setImageResource(currentSport.getImageResource());
        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @Override
        public void onClick(View view) {
            WebInfo mInfo = Information.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, detail.class);
            detailIntent.putExtra("url", mInfo.getUrl());
            detailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(detailIntent);
        }
    }
}
