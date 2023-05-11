package com.example.start.network;

import com.example.start.data.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONMessagesApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);
}
