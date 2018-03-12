package pl.jurassic.godtrecipes.util.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import pl.jurassic.godtrecipes.BaseGodtApp
import pl.jurassic.godtrecipes.util.injection.binding.ActivityBinderModule
import pl.jurassic.godtrecipes.util.injection.binding.FragmentBinderModule
import pl.jurassic.godtrecipes.util.injection.modules.DatabaseModule
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RuntimeScope

@Module
class AppModule {

    @Provides
    fun context(application: Application): Context =
            application

    @Provides
    fun compositeDisposable(): CompositeDisposable =
            CompositeDisposable()
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBinderModule::class,
    FragmentBinderModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseGodtApp)
}
