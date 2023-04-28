package com.example.task51;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class VerticalAdaptor extends RecyclerView.Adapter<VerticalAdaptor.MyViewHolder> {

    Context mContext;
    ArrayList<MyDataModel> newsList;

    //constructor for use in MainAcitivty
    public VerticalAdaptor(Context mContext, ArrayList<MyDataModel> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public VerticalAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout
        View view = LayoutInflater.from(mContext).inflate(R.layout.verticalrecyclerview_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAdaptor.MyViewHolder holder, int position) {
        //attach data to the layout
        holder.topTitleTextView.setText(newsList.get(position).getTitle());
        Glide.with(holder.topImageView).load(newsList.get(position).getImageUrl()).into(holder.topImageView);
        holder.topDescriptionTextView.setText(newsList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        //get the size of the arrayList
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView topTitleTextView;
        ImageView topImageView;

        TextView topDescriptionTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //attach items in view to variables
            topTitleTextView = itemView.findViewById(R.id.topTitleTextView);
            topImageView = itemView.findViewById(R.id.newsImageView);
            topDescriptionTextView = itemView.findViewById(R.id.topDescriptionTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment newStoryFragment = new NewsStoryFragment();

            //settings up bundle to send data of specific recyclerview clicked item to fragment
            Bundle args = new Bundle();
            int position = getLayoutPosition();
            args.putSerializable("data", (Serializable) newsList.get(position));
            args.putString("type", "standardAdaptor");

            newStoryFragment.setArguments(args);

            //show fragment with animation
            activity.getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in,  // enter
                            R.anim.fade_out,  // exit
                            R.anim.fade_in,   // popEnter
                            R.anim.slide_out  // popExit
                    )
                    .replace(R.id.frameLayout, newStoryFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
