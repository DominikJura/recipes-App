package pl.jurassic.godtrecipes.util.repository.api

interface ApiServiceGenerator {

    fun <T> createService(serviceClass: Class<T>): T
}
