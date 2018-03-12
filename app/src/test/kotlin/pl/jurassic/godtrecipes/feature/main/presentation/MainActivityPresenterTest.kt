package pl.jurassic.godtrecipes.feature.main.presentation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.jurassic.godtrecipes.BaseTest
import pl.jurassic.godtrecipes.feature.main.MainActivityContract

class MainActivityPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: MainActivityContract.View

    private lateinit var presenter: MainActivityContract.Presenter

    override fun setup() {
        super.setup()
        presenter = MainActivityPresenter(view)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(view)
    }

    @Test
    fun `should show main fragment after initialize is called`() {
        presenter.initialize()

        verify(view, times(1)).showMainFragment()
    }

    @Test
    fun `should do nothing after clear is called`() {
        presenter.clear()
    }
}