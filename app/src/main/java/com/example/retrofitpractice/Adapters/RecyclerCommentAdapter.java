package com.example.retrofitpractice.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.Pojos.CommentResponsePojo;

import java.util.List;

public class RecyclerCommentAdapter extends RecyclerView.Adapter<RecyclerCommentAdapter.MyViewHolder> {
    final private Context context;
    final private List<CommentResponsePojo> datalist;

    public RecyclerCommentAdapter(Context context, List<CommentResponsePojo> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public RecyclerCommentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comments_recycler_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCommentAdapter.MyViewHolder holder, int position) {

        holder.postID.setText("PostID : "+ datalist.get(position).getPostId());
        holder.ID.setText("ID :" + datalist.get(position).getId());
        holder.name.setText("Name : "+ datalist.get(position).getName());
        holder.email.setText("Email :" + datalist.get(position).getEmail());
        holder.body.setText("Body :" + datalist.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
         TextView postID, ID, name, email, body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postID = (TextView) itemView.findViewById(R.id.PostID);
            ID = (TextView)itemView.findViewById(R.id.ID);
            name =  (TextView)itemView.findViewById(R.id.Name);
            email = (TextView)itemView.findViewById(R.id.Email);
            body = (TextView)itemView.findViewById(R.id.Body);
        }
    }
}
