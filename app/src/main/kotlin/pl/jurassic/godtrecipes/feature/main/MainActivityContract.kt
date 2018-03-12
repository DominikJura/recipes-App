package pl.jurassic.godtrecipes.feature.main

import pl.jurassic.godtrecipes.feature.common.BaseContract

interface MainActivityContract {

    interface View {
        fun showMainFragment()
    }

    interface Router

    interface Presenter : BaseContract.Presenter
}