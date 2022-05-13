package com.example.retrofitpractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.Pojos.PhotoResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.Users.UserResponsePojo;

import java.util.List;

public class RecyclerPhotoAdapter  extends RecyclerView.Adapter<RecyclerPhotoAdapter.MyViewHolder> {
    final private Context context;
    final private List<PhotoResponsePojo> datalist;

    public RecyclerPhotoAdapter(Context context, List<PhotoResponsePojo> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public RecyclerPhotoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photos_recycler_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPhotoAdapter.MyViewHolder holder, int position) {

        holder.id.setText("ID :" + datalist.get(position).getId());
        holder.albumID.setText("AlbumID :" + datalist.get(position).getAlbumId());
        holder.title.setText("Title :" + datalist.get(position).getTitle());
        holder.url.setText("Url : " + datalist.get(position).getUrl());
        holder.thumbnailUrl.setText("Thumbnail :" + datalist.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView albumID,id,title,url,thumbnailUrl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            albumID = (TextView) itemView.findViewById(R.id.AlbumIDPhoto);
            id = (TextView) itemView.findViewById(R.id.IDPhoto);
            title = (TextView) itemView.findViewById(R.id.TitlePhoto);
            url = (TextView) itemView.findViewById(R.id.UrlPhoto);
            thumbnailUrl = (TextView) itemView.findViewById(R.id.ThumbnailUrlPhoto);
        }
    }
}
