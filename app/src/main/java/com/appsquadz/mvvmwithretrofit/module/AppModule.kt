package com.appsquadz.mvvmwithretrofit.module

import com.appsquadz.mvvmwithretrofit.interfaces.ApiInterface
import com.appsquadz.mvvmwithretrofit.repository.MenuMasterRepository
import com.appsquadz.mvvmwithretrofit.utils.Apis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient {
        val httpClient:OkHttpClient.Builder = OkHttpClient.Builder()

        httpClient.addInterceptor(Interceptor {
            val request = it.request()
                .newBuilder()
                .build()
            return@Interceptor it.proceed(request)
        }).connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

        return httpClient.build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Apis.SERVER_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiInterface = retrofit.create(ApiInterface::class.java)


    @Provides
    @Singleton
    fun provideMenuMasterRepository(apiInterface: ApiInterface) = MenuMasterRepository(apiInterface)


}