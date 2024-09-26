package com.example.domain.usecase

import com.example.domain.model.PostListEntity
import com.example.domain.repository.PostListRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostListUseCase @Inject constructor(
    private val postListRepository: PostListRepository
) {
    suspend operator fun invoke(): Flow<Result<List<PostListEntity>>> =
        postListRepository.getPostList()
}