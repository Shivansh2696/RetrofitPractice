package com.example.retrofitpractice.Retrofit.Pojos;

import com.google.gson.annotations.SerializedName;

public class PostResponsePojo {
        @SerializedName("userId")
        private int userId;

        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("body")
        private String body;


    public int getUserId() {
            return userId;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

