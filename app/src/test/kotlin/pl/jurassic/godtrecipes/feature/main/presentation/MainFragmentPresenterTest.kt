package pl.jurassic.godtrecipes.feature.main.presentation

import io.reactivex.BackpressureStrategy
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.jurassic.godtrecipes.BaseTest
import pl.jurassic.godtrecipes.data.database.RecipeWithIngredients
import pl.jurassic.godtrecipes.feature.main.MainFragmentContract
import pl.jurassic.godtrecipes.util.repository.Repository

class MainFragmentPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: MainFragmentContract.View

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var recipeList: List<RecipeWithIngredients>

    private lateinit var presenter: MainFragmentContract.Presenter

    private var recipesSubject: PublishSubject<List<RecipeWithIngredients>> = PublishSubject.create()
    private var fetchSubject: PublishSubject<Unit> = PublishSubject.create()

    override fun setup() {
        super.setup()
        trampolineRxPlugin()

        presenter = MainFragmentPresenter(view, repository, compositeDisposable)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(repository, compositeDisposable, recipeList)
    }

    @Test
    fun `should show recipeList after initialize is called`() {
        `when`(repository.getLocalRecipeList()).thenReturn(recipesSubject.toFlowable(BackpressureStrategy.LATEST))
        `when`(repository.fetchRecipeList()).thenReturn(fetchSubject)

        presenter.initialize()

        recipesSubject.onNext(recipeList)

        verify(compositeDisposable, times(2)).add(any(Disposable::class.java))
        verify(repository, times(1)).fetchRecipeList()
        verify(repository, times(1)).getLocalRecipeList()
        verify(view, times(1)).setRecipesList(recipeList)
    }

    @Test
    fun `should clear composite disposable after clear is called`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }
}