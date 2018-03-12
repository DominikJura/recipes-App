package pl.jurassic.godtrecipes.util.repository.api.service

import io.reactivex.Observable
import pl.jurassic.godtrecipes.data.api.RecipeData
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesService {

    companion object {
        private const val DEFAULT_TAGS = ""
        private const val DEFAULT_SIZE = "thumbnail-medium"
        private const val DEFAULT_RATIO = 1
        private const val DEFAULT_LIMIT = 50
        private const val DEFAULT_FROM = 0
    }

    @GET("getRecipesListDetailed")
    fun recipes(
            @Query("tags") tags: String? = DEFAULT_TAGS,
            @Query("size") size: String = DEFAULT_SIZE,
            @Query("ratio") ratio: Int = DEFAULT_RATIO,
            @Query("limit") limit: Int = DEFAULT_LIMIT,
            @Query("from") from: Int = DEFAULT_FROM
    ): Observable<List<RecipeData>>
}