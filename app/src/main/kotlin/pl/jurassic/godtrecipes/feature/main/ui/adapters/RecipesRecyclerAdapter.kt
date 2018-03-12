package pl.jurassic.godtrecipes.feature.main.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.jurassic.godtrecipes.R
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.feature.main.ui.view.RecipesViewHolder

class RecipesRecyclerAdapter(
        private val recipesList: MutableList<RecipeWithIngredients>
) : RecyclerView.Adapter<RecipesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_recipe, parent, false)
        return RecipesViewHolder(view)
    }

    override fun getItemCount(): Int = recipesList.size

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.setItem(recipesList[position])
    }

    fun updateRecipes(recipes: List<RecipeWithIngredients>) {
        //TODO check list Diff then replace
        recipesList.apply {
            clear()
            addAll(recipes)
        }
        notifyDataSetChanged()
    }
}