package pl.jurassic.godtrecipes.feature.main.ui

import android.support.v7.widget.RecyclerView
import butterknife.BindView
import pl.jurassic.godtrecipes.R
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.feature.common.ui.BaseFragment
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract.Presenter
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract.View
import pl.jurassic.godtrecipes.feature.main.ui.adapters.RecipesRecyclerAdapter
import javax.inject.Inject

class MainFragment : BaseFragment<Presenter>(), View {

    @BindView(R.id.main_recipe_recycler)
    lateinit var recipeRecyclerView: RecyclerView

    @Inject
    lateinit var recyclerLayoutManager: RecyclerView.LayoutManager

    @Inject
    lateinit var recyclerAdapter: RecipesRecyclerAdapter

    override val layoutId: Int = R.layout.fragment_main

    override fun initialize() {
        super.initialize()
        initRecycler()
    }

    private fun initRecycler() = with(recipeRecyclerView) {
        layoutManager = recyclerLayoutManager
        adapter = recyclerAdapter
    }

    override fun setRecipesList(recipes: List<RecipeWithIngredients>) {
        recyclerAdapter.updateRecipes(recipes)
    }
}