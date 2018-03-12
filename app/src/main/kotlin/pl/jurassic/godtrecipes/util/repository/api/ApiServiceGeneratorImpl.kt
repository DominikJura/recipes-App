package pl.jurassic.godtrecipes.util.repository.api

import retrofit2.Retrofit

class ApiServiceGeneratorImpl(private val retrofit: Retrofit) : ApiServiceGenerator {

    override fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}