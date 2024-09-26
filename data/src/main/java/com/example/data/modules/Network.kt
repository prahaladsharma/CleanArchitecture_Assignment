package com.example.data.modules

import com.example.data.BuildConfig
import com.example.data.api.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    @Singleton
    fun providePostListService(okHttpClient: OkHttpClient): PostApiService =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
            .create(PostApiService::class.java)


    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(createInterceptor())
            .build()

    fun createInterceptor(): HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor()

        BuildConfig.DEBUG.takeIf { it }.let {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } ?: run {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return  loggingInterceptor
    }
}