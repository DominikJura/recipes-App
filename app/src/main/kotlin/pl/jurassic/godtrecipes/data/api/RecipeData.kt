package pl.jurassic.godtrecipes.data.api

data class RecipeData(
        val id: Int,
        val title: String,
        val description: String,
        val images: List<ImageData>,
        val ingredients: List<IngredientsContainer>
)