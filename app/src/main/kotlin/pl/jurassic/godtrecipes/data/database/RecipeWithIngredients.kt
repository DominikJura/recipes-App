package pl.jurassic.godtrecipes.data.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

class RecipeWithIngredients {

    @Embedded
    var recipe: Recipe? = null

    @Relation(parentColumn = "recipeId", entityColumn = "recipe")
    var ingredients: List<Ingredient> = ArrayList()
}