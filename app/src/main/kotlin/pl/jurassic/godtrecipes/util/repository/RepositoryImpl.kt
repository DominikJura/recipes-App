package pl.jurassic.godtrecipes.util.repository

import io.reactivex.Flowable
import io.reactivex.Observable
import pl.jurassic.godtrecipes.data.api.RecipeData
import pl.jurassic.godtrecipes.data.database.Ingredient
import pl.jurassic.godtrecipes.data.database.Recipe
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.util.database.RecipesDao
import pl.jurassic.godtrecipes.util.repository.api.service.RecipesService

class RepositoryImpl(
        private val recipesService: RecipesService,
        private val recipesDao: RecipesDao
) : Repository {

    override fun fetchRecipeList(): Observable<Unit> =
        recipesService.recipes()
                .flatMapIterable { it }
                .doOnNext { saveData(it) }
                .map { Unit }

    private fun saveData(recipeData: RecipeData) = with(recipeData) {
        val recipe = Recipe(id, title, description, images[0].url)

        ingredients.forEach {
            it.elements.forEach {
                recipesDao.insertIngredient(Ingredient(it.name, it.amount, it.unitName, id))
            }
        }

        recipesDao.insertRecipe(recipe)
    }

    override fun getLocalRecipeList(): Flowable<List<RecipeWithIngredients>> =
        recipesDao.getAllRecipes()
}