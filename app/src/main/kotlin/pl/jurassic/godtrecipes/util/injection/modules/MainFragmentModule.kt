package pl.jurassic.godtrecipes.util.injection.modules

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract
import pl.jurassic.godtrecipes.feature.main.presentation.MainFragmentPresenter
import pl.jurassic.godtrecipes.feature.main.ui.MainFragment
import pl.jurassic.godtrecipes.feature.main.ui.adapters.RecipesRecyclerAdapter
import pl.jurassic.godtrecipes.util.database.RecipesDao
import pl.jurassic.godtrecipes.util.injection.RuntimeScope
import pl.jurassic.godtrecipes.util.repository.Repository
import pl.jurassic.godtrecipes.util.repository.RepositoryImpl
import pl.jurassic.godtrecipes.util.repository.api.service.RecipesService

@Module
class MainFragmentModule {

    @Provides
    fun view(fragment: MainFragment): MainFragmentContract.View = fragment

    @Provides
    fun recyclerLayoutManager(fragment: MainFragment): RecyclerView.LayoutManager =
            LinearLayoutManager(fragment.context, LinearLayoutManager.VERTICAL, false)

    @Provides
    fun recipesList(): MutableList<RecipeWithIngredients> =
            arrayListOf()

    @Provides
    fun recipesAdapter(recipesList: MutableList<RecipeWithIngredients>): RecipesRecyclerAdapter =
            RecipesRecyclerAdapter(recipesList)

    @Provides
    fun repository(recipesService: RecipesService, recipesDao: RecipesDao): Repository =
            RepositoryImpl(recipesService, recipesDao)

    @RuntimeScope
    @Provides
    fun presenter(
            view: MainFragmentContract.View,
            repository: Repository,
            compositeDisposable: CompositeDisposable
    ): MainFragmentContract.Presenter =
            MainFragmentPresenter(view, repository, compositeDisposable)
}