package pl.jurassic.godtrecipes.data.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
        @PrimaryKey val recipeId: Int,
        val title: String,
        val description: String,
        val imageUrl: String
)