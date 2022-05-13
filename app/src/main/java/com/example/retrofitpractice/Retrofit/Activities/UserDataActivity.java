package com.example.retrofitpractice.Retrofit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitpractice.Adapters.RecyclerPhotoAdapter;
import com.example.retrofitpractice.Adapters.RecyclerPostAdapter;
import com.example.retrofitpractice.Adapters.RecyclerUserAdapter;
import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.ApiName;
import com.example.retrofitpractice.Retrofit.Pojos.PhotoResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.PostResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.Users.UserResponsePojo;
import com.example.retrofitpractice.Retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    List<UserResponsePojo> list = new ArrayList<>();
    RecyclerUserAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        recyclerView = findViewById(R.id.recyclerViewUser);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchData();
    }

    private void fetchData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ApiName apiServices = RetrofitApi.getRetrofit().create(ApiName.class);
        Call<List<UserResponsePojo>> call = apiServices.getUsersData();
        call.enqueue(new Callback<List<UserResponsePojo>>() {
            @Override
            public void onResponse(Call<List<UserResponsePojo>> call, Response<List<UserResponsePojo>> response) {
                progressDialog.dismiss();
                list = response.body();
                adapter = new RecyclerUserAdapter(getApplicationContext(),list);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<UserResponsePojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(UserDataActivity.this, "Error : " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}