package com.hifamily.hidaddy.util.injection

import com.hifamily.hidaddy.util.injection.modules.BaseNetworkModule
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun okHttp(cache: Cache): OkHttpClient =
            OkHttpClient.Builder()
                    .cache(cache)
                    .build()
}
