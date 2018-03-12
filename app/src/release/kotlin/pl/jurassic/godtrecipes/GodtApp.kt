package pl.jurassic.godtrecipes

import pl.jurassic.godtrecipes.util.ReleaseTree
import timber.log.Timber

class GodtApp : BaseGodtApp() {

    override fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}