package com.example.retrofitpractice.Retrofit;

import com.example.retrofitpractice.Retrofit.Pojos.CommentResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.PhotoResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.PostResponsePojo;
import com.example.retrofitpractice.Retrofit.Pojos.Users.UserResponsePojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {
        @GET("posts")
        Call<List<PostResponsePojo>> getPostsData();

        @GET("comments")
        Call<List<CommentResponsePojo>> getCommentsData();

        @GET("photos")
        Call<List<PhotoResponsePojo>> getPhotoData();

        @GET("users")
        Call<List<UserResponsePojo>> getUsersData();
}
