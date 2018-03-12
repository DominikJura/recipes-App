package pl.jurassic.godtrecipes.util.injection

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import pl.jurassic.godtrecipes.util.injection.modules.BaseNetworkModule
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
