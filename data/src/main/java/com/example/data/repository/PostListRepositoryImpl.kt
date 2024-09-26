package com.example.data.repository

import com.example.data.api.PostApiService
import com.example.data.mappers.toPostListEntity
import com.example.domain.model.PostListEntity
import com.example.domain.repository.PostListRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostListRepositoryImpl @Inject constructor(
    private val postListApiService: PostApiService,
) : PostListRepository {
    override suspend fun getPostList(): Flow<Result<List<PostListEntity>>> =
        safeApiCall(
            apiCall = { postListApiService.getPostListApi() },
            mapper = { response ->
                response.toPostListEntity()
            }
        )
}
