package pl.jurassic.godtrecipes.util.injection.binding

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.jurassic.godtrecipes.feature.main.ui.MainActivity
import pl.jurassic.godtrecipes.util.injection.RuntimeScope
import pl.jurassic.godtrecipes.util.injection.modules.MainActivityModule

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @RuntimeScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
