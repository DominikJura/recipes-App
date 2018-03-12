package pl.jurassic.godtrecipes.util.injection

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.jurassic.godtrecipes.util.injection.modules.BaseNetworkModule
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun okHttp(
            cache: Cache,
            loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .cache(cache)
                    .build()

    @Singleton
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
}
