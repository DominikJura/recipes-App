package pl.jurassic.godtrecipes.util.repository

import org.junit.Test
import org.mockito.Mock
import pl.jurassic.godtrecipes.BaseTest
import pl.jurassic.godtrecipes.util.database.RecipesDao
import pl.jurassic.godtrecipes.util.repository.api.service.RecipesService

class RepositoryTest : BaseTest() {

    @Mock
    private lateinit var recipesService: RecipesService

    @Mock
    private lateinit var recipesDao: RecipesDao

    private lateinit var repository: Repository

    override fun setup() {
        super.setup()

        repository = RepositoryImpl(recipesService, recipesDao)
    }

    @Test
    fun fetchRecipeList() {
        //TODO write test
    }

    @Test
    fun getLocalRecipeList() {
        //TODO write test
    }
}