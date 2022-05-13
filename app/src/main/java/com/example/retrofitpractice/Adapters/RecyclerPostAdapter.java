package com.example.retrofitpractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.Pojos.PostResponsePojo;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPostAdapter extends RecyclerView.Adapter<RecyclerPostAdapter.MyViewHolder>{
    final private Context context;
    final private List<PostResponsePojo> datalist;
    public RecyclerPostAdapter(Context context,List<PostResponsePojo> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public RecyclerPostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.posts_recycler_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPostAdapter.MyViewHolder holder, int position) {
        holder.userId.setText(""+datalist.get(position).getUserId());
        holder.id.setText(""+datalist.get(position).getId());
        holder.title.setText(datalist.get(position).getTitle());
        holder.body.setText(datalist.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userId, id, title,body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = (TextView) itemView.findViewById(R.id.userID);
            id = (TextView)itemView.findViewById(R.id.ID);
            title =(TextView) itemView.findViewById(R.id.Title);
            body = (TextView)itemView.findViewById(R.id.Body);
        }
    }
}