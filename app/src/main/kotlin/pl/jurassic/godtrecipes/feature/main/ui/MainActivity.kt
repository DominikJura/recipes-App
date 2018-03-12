package pl.jurassic.godtrecipes.feature.main.ui

import pl.jurassic.godtrecipes.R
import pl.jurassic.godtrecipes.feature.common.ui.BaseActivity
import pl.jurassic.godtrecipes.feature.main.MainActivityContract.Presenter
import pl.jurassic.godtrecipes.feature.main.MainActivityContract.View

class MainActivity : BaseActivity<Presenter>(), View {

    override val layoutId: Int = R.layout.activity_main

    override fun showMainFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_root, MainFragment())
                .commit()
    }
}