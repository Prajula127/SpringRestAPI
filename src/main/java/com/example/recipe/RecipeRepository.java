// Write your code here
package com.example.recipe;

import java.util.*;

interface RecipeRepository {
    ArrayList<Recipe> getRecipes();
    Recipe getRecipeById(int recipeId);
    Recipe addRecipe(Recipe recipe);
    Recipe updateRecipe(int recipeId, Recipe recipe);
    void deleteRecipe(int recipeId);
}