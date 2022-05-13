package com.example.retrofitpractice.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractice.Adapters.RecyclerCommentAdapter;
import com.example.retrofitpractice.Adapters.RecyclerPhotoAdapter;
import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.ApiName;
import com.example.retrofitpractice.Retrofit.Pojos.CommentResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.PhotoResponsePojo;
import com.example.retrofitpractice.Retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    List<PhotoResponsePojo> list = new ArrayList<>();
    RecyclerPhotoAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_data);
        recyclerView = findViewById(R.id.recyclerViewPhotos);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchPhotos();
    }

    private void fetchPhotos() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ApiName apiServices = RetrofitApi.getRetrofit().create(ApiName.class);
        Call<List<PhotoResponsePojo>> call = apiServices.getPhotoData();
        call.enqueue(new Callback<List<PhotoResponsePojo>>() {
            @Override
            public void onResponse(Call<List<PhotoResponsePojo>> call, Response<List<PhotoResponsePojo>> response) {
                progressDialog.dismiss();
                list = response.body();
                adapter = new RecyclerPhotoAdapter(getApplicationContext(),list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PhotoResponsePojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(PhotoDataActivity.this, "Error : " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}