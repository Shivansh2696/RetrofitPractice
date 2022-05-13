package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitpractice.Retrofit.Activities.CommentsDataActivity;
import com.example.retrofitpractice.Retrofit.Activities.PhotoDataActivity;
import com.example.retrofitpractice.Retrofit.Activities.PostsDataActivity;
import com.example.retrofitpractice.Retrofit.Activities.UserDataActivity;
import com.example.retrofitpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.posts.setOnClickListener(this::Onclick);
        binding.comments.setOnClickListener(this::Onclick);
        binding.photos.setOnClickListener(this::Onclick);
        binding.todos.setOnClickListener(this::Onclick);
        binding.users.setOnClickListener(this::Onclick);
    }

    public void Onclick(View view) {
        int id = view.getId();
        if(id == binding.posts.getId()){
            Intent intent = new Intent(this,PostsDataActivity.class);
            startActivity(intent);
        }
        else if(id == binding.comments.getId()){
            Intent intent = new Intent(this, CommentsDataActivity.class);
            startActivity(intent);
        }
        else if(id == binding.photos.getId()){
            Intent intent = new Intent(this, PhotoDataActivity.class);
            startActivity(intent);
        }
        else if(id == binding.users.getId()){
            Intent intent = new Intent(this, UserDataActivity.class);
            startActivity(intent);
        }
    }
}