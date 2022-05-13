package com.example.retrofitpractice.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitpractice.Adapters.RecyclerPostAdapter;
import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.ApiName;
import com.example.retrofitpractice.Retrofit.Pojos.PostResponsePojo;
import com.example.retrofitpractice.Retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsDataActivity extends AppCompatActivity  {
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    List<PostResponsePojo> list = new ArrayList<>();
    RecyclerPostAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_data);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchPosts();
    }

    private void fetchPosts() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ApiName apiServices = RetrofitApi.getRetrofit().create(ApiName.class);
        Call<List<PostResponsePojo>> call = apiServices.getPostsData();
        call.enqueue(new Callback<List<PostResponsePojo>>() {
            @Override
            public void onResponse(Call<List<PostResponsePojo>> call, Response<List<PostResponsePojo>> response) {
                progressDialog.dismiss();
                list = response.body();
                adapter = new RecyclerPostAdapter(PostsDataActivity.this,list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostResponsePojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(PostsDataActivity.this, "Error : " + t, Toast.LENGTH_SHORT).show();

            }
        });

    }
}