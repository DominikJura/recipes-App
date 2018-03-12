package pl.jurassic.godtrecipes.feature.main.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract.Presenter
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract.View
import pl.jurassic.godtrecipes.util.repository.Repository
import timber.log.Timber

class MainFragmentPresenter(
        private val view: View,
        private val repository: Repository,
        private val compositeDisposable: CompositeDisposable
) : Presenter {

    override fun initialize() {
        compositeDisposable.add(repository
                .fetchRecipeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( { }, { Timber.e(it) } ))

        compositeDisposable.add(repository
                .getLocalRecipeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    view.setRecipesList(it)
                }, { Timber.e(it)}))
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}