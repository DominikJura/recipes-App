package pl.jurassic.godtrecipes.util.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.jurassic.godtrecipes.data.database.Ingredient
import pl.jurassic.godtrecipes.data.database.Recipe

@Database(entities = [(Recipe::class), (Ingredient::class)], version = 1, exportSchema = false)
abstract class RecipesDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipesDao
}