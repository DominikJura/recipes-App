package pl.jurassic.godtrecipes.feature.main

import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.feature.common.BaseContract

interface MainFragmentContract {

    interface View {
        fun setRecipesList(recipes: List<RecipeWithIngredients>)
    }

    interface Router

    interface Presenter : BaseContract.Presenter
}