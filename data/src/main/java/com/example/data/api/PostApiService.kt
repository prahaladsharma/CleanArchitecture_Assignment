package com.example.data.api

import com.example.data.models.PostListDTO
import retrofit2.Response
import retrofit2.http.GET

interface PostApiService {

    @GET("/posts")
    suspend fun getPostListApi(): Response<List<PostListDTO>>
}