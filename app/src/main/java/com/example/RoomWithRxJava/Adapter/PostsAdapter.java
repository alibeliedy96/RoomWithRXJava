package com.example.RoomWithRxJava.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.RoomWithRxJava.DataBase.Model.Posts;
import com.example.posts.R;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<Posts> posts = new ArrayList<>();

    public PostsAdapter() {
    }

    public PostsAdapter(List<Posts> posts) {
        this.posts = posts;
    }

    public void changeData(List<Posts> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
                Posts postsItem=posts.get(position);
                holder.titleTV.setText(postsItem.getTitle());
                holder.bodyTV.setText(postsItem.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.item_title);
            bodyTV = itemView.findViewById(R.id.item_body);
        }
    }
}
