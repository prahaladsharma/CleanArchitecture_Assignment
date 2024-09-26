package com.example.domain.repository

import com.example.domain.model.PostListEntity
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface PostListRepository {
    suspend fun getPostList(): Flow<Result<List<PostListEntity>>>
}