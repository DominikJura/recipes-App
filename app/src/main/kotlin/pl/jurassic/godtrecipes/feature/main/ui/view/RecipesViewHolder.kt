package pl.jurassic.godtrecipes.feature.main.ui.view

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import pl.jurassic.godtrecipes.R
import pl.jurassic.godtrecipes.data.database.Ingredient
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients

class RecipesViewHolder(dailiesView: View) : RecyclerView.ViewHolder(dailiesView) {

    @BindView(R.id.recipe_title)
    lateinit var recipeTitleTextView: TextView

    @BindView(R.id.recipe_description)
    lateinit var recipeDescriptionTextView: TextView

    @BindView(R.id.recipe_ingredients)
    lateinit var recipeIngredientsTextView: TextView

    @BindView(R.id.recipe_image)
    lateinit var recipeImageView: ImageView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setItem(recipeWithIngredients: RecipeWithIngredients) = with(recipeWithIngredients) {
        recipeTitleTextView.text = recipe?.title
        recipeDescriptionTextView.text = Html.fromHtml(recipe?.description)
        recipeIngredientsTextView.text = parseIngredients(ingredients)

        Picasso.get()
                .load(recipe?.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(recipeImageView)
    }

    private fun parseIngredients(ingredients: List<Ingredient>): String {
        val ingredientString = StringBuilder()
        ingredientString.append(itemView.context.getString(R.string.ingredients))
        ingredients.forEach {
            ingredientString.append("${it.amount} ${it.unitName} of ${it.name}, ")
        }
        return ingredientString.toString()
    }
}