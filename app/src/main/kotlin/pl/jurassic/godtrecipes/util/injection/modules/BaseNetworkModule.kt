package pl.jurassic.godtrecipes.util.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import pl.jurassic.godtrecipes.util.StringConstants
import pl.jurassic.godtrecipes.util.repository.api.ApiServiceGenerator
import pl.jurassic.godtrecipes.util.repository.api.ApiServiceGeneratorImpl
import pl.jurassic.godtrecipes.util.repository.api.service.RecipesService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class BaseNetworkModule {

    companion object {
        private const val cacheFileSize: Long = 4 * 1024 * 1024
    }

    @Singleton
    @Provides
    @Named("cacheSize")
    fun cacheFileSize(): Long = cacheFileSize

    @Singleton
    @Provides
    fun cacheFile(context: Context): File = File(context.cacheDir, "responses")

    @Singleton
    @Provides
    fun cache(cacheFile: File, @Named("cacheSize") cacheSize: Long) = Cache(cacheFile, cacheSize)

    @Singleton
    @Provides
    fun retrofit(httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(StringConstants.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    @Provides
    fun apiServiceGenerator(retrofit: Retrofit): ApiServiceGenerator = ApiServiceGeneratorImpl(retrofit)

    @Provides
    fun recipesService(apiServiceGenerator: ApiServiceGenerator): RecipesService =
            apiServiceGenerator.createService(RecipesService::class.java)
}