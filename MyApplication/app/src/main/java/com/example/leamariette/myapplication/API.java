package com.example.leamariette.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leamariette on 05/05/2017.
 */

public interface API {

    @GET("?json=get_category_posts")
    Call<ListPosts> getPostsByCategory(@Query("id") int categoryId);
}