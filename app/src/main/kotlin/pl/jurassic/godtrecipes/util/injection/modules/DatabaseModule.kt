package pl.jurassic.godtrecipes.util.injection.modules

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.jurassic.godtrecipes.util.database.RecipesDatabase

@Module
class DatabaseModule {

    @Provides
    fun recipesDatabase(context: Context): RecipesDatabase =
            Room.databaseBuilder(context, RecipesDatabase::class.java, "recipes-db").allowMainThreadQueries().build()

    @Provides
    fun recipesDao(database: RecipesDatabase) = database.recipeDao()
}