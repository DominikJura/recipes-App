package pl.jurassic.godtrecipes.util.injection.binding

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.jurassic.godtrecipes.feature.main.ui.MainFragment
import pl.jurassic.godtrecipes.util.injection.RuntimeScope
import pl.jurassic.godtrecipes.util.injection.modules.MainFragmentModule

@Module
abstract class FragmentBinderModule {

    @Binds
    abstract fun fragment(fragment: Fragment): Fragment

    @RuntimeScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment(): MainFragment
}
