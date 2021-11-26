package com.cryptenet.rwl_rest.di.modules.app

import com.cryptenet.rwl_rest.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit

internal const val MODULE_NAME = "App"

val appModule = DI.Module("${MODULE_NAME}Module") {
    bind<HttpLoggingInterceptor>() with singleton {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    bind<Retrofit.Builder>() with singleton { Retrofit.Builder() }

    bind<OkHttpClient.Builder>() with singleton { OkHttpClient.Builder() }

    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(instance<HttpLoggingInterceptor>())
            .build()
    }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(BuildConfig.API_BASE)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(instance())
            .build()
    }
}
