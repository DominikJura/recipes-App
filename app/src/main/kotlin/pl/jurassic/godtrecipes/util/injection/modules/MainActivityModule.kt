package pl.jurassic.godtrecipes.util.injection.modules

import dagger.Module
import dagger.Provides
import pl.jurassic.godtrecipes.feature.main.MainActivityContract
import pl.jurassic.godtrecipes.feature.main.presentation.MainActivityPresenter
import pl.jurassic.godtrecipes.feature.main.ui.MainActivity
import pl.jurassic.godtrecipes.util.injection.RuntimeScope

@Module
class MainActivityModule {

    @Provides
    fun view(activity: MainActivity): MainActivityContract.View = activity

    @RuntimeScope
    @Provides
    fun presenter(view: MainActivityContract.View): MainActivityContract.Presenter =
            MainActivityPresenter(view)
}