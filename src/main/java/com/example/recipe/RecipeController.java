
/*
 * 
 * You can use the following import statements
 * 
 */

package com.example.recipe;

import org.springframework.web.bind.annotation.*;
import java.util.*;

// Write your code here
@RestController
public class RecipeController {
    RecipeService apiRecipe = new RecipeService();
    
    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipes() {
        return apiRecipe.getRecipes();
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") int recipeId) {
        return apiRecipe.getRecipeById(recipeId);
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return apiRecipe.addRecipe(recipe);
    }

    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable("recipeId") int recipeId, @RequestBody Recipe recipe) {
        return apiRecipe.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") int recipeId) {
        apiRecipe.deleteRecipe(recipeId);   
    }

}