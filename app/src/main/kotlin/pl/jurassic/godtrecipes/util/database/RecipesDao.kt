package pl.jurassic.godtrecipes.util.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import io.reactivex.Flowable
import pl.jurassic.godtrecipes.data.database.Ingredient
import pl.jurassic.godtrecipes.data.database.Recipe
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients

@Dao
interface RecipesDao {

    @Transaction
    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flowable<List<RecipeWithIngredients>>

    @Insert(onConflict = REPLACE)
    fun insertRecipe(recipe: Recipe)

    @Insert(onConflict = REPLACE)
    fun insertIngredient(ingredient: Ingredient)
}