package pl.jurassic.godtrecipes

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pl.jurassic.godtrecipes.util.injection.DaggerAppComponent
import javax.inject.Inject

abstract class BaseGodtApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        init()
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector

    open fun init() {
        initTimber()
        initAppComponent()
    }

    private fun initAppComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    abstract fun initTimber()
}
