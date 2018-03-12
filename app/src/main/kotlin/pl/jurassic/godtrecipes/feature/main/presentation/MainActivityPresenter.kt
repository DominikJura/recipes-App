package pl.jurassic.godtrecipes.feature.main.presentation

import pl.jurassic.godtrecipes.feature.main.MainActivityContract.Presenter
import pl.jurassic.godtrecipes.feature.main.MainActivityContract.View

class MainActivityPresenter(private val view: View) : Presenter {

    override fun initialize() {
        view.showMainFragment()
    }

    override fun clear() = Unit
}