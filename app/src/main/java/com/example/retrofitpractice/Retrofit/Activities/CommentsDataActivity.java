package com.example.retrofitpractice.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractice.Adapters.RecyclerCommentAdapter;
import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.ApiName;
import com.example.retrofitpractice.Retrofit.Pojos.CommentResponsePojo;
import com.example.retrofitpractice.Retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsDataActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    List<CommentResponsePojo> list = new ArrayList<>();
    RecyclerCommentAdapter adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_data);
        recyclerView = findViewById(R.id.recyclerViewComments);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchComments();
    }

    private void fetchComments() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ApiName apiServices = RetrofitApi.getRetrofit().create(ApiName.class);
        Call<List<CommentResponsePojo>> call = apiServices.getCommentsData();
        call.enqueue(new Callback<List<CommentResponsePojo>>(){

            @Override
            public void onResponse(Call<List<CommentResponsePojo>> call, Response<List<CommentResponsePojo>> response) {
                progressDialog.dismiss();
                list = response.body();
                adapter = new RecyclerCommentAdapter(getApplicationContext(), list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CommentResponsePojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CommentsDataActivity.this, "Error : " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}