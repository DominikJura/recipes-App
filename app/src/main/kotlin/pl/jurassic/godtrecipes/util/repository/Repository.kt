package pl.jurassic.godtrecipes.util.repository

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients

interface Repository {

    fun fetchRecipeList() : Observable<Unit>
    fun getLocalRecipeList(): Flowable<List<RecipeWithIngredients>>
}