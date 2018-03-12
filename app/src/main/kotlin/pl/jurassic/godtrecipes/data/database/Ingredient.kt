package pl.jurassic.godtrecipes.data.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "ingredient")
data class Ingredient(
        val name: String,
        val amount: Float,
        val unitName: String,
        val recipe: Int
) {
    @PrimaryKey()
    var id: String = "$recipe$name"
}