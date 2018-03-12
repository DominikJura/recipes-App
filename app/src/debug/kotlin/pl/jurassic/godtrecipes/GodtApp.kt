package pl.jurassic.godtrecipes

import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

class GodtApp : BaseGodtApp() {

    override fun init() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        initLeakCanary()
        super.init()
    }

    private fun initLeakCanary() {
        LeakCanary.install(this)
    }

    override fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
