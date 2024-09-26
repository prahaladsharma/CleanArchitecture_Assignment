package com.example.data.mappers

import com.example.data.models.PostListDTO
import com.example.domain.model.PostListEntity


fun List<PostListDTO>.toPostListEntity(): List<PostListEntity> =
    this.map { items ->
        PostListEntity(
            id = items.id,
            userId = items.userId,
            body = items.body,
            title = items.title
        )
    }