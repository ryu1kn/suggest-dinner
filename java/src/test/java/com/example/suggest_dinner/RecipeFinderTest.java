package com.example.suggest_dinner;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecipeFinderTest {

    @Test
    public void pickBeefSteakRecipe() {
        Recipe recipe = buildRecipe("Beef Steak", Arrays.asList("Beef"));
        RecipeBook book = buildRecipeBook(recipe);
        Stock stock = buildStock("Beef");
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Arrays.asList(recipe), finder.find());
    }

    @Test
    public void pickBeefSteakRecipeButNotPorkSteak() {
        Recipe beefSteak = buildRecipe("Beef Steak", Arrays.asList("beef"));
        Recipe porkSteak = buildRecipe("Pork Steak", Arrays.asList("pork"));
        RecipeBook book = buildRecipeBook(porkSteak, beefSteak);
        Stock stock = buildStock("beef");
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Arrays.asList(beefSteak), finder.find());
    }

    @Test
    public void findNoRecipesIfNotEnoughIngredients() {
        Recipe beefSteak = buildRecipe("Beef Steak", Arrays.asList("beef"));
        RecipeBook book = buildRecipeBook(beefSteak);
        Stock stock = buildStock();
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Collections.emptyList(), finder.find());
    }

    private RecipeBook buildRecipeBook(Recipe... recipes) {
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(recipes));
        return book;
    }

    private Recipe buildRecipe(String name, List<String> ingredients) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        return recipe;
    }

    private Stock buildStock(String... ingredients) {
        Stock stock = new Stock();
        stock.setIngredients(Arrays.asList(ingredients));
        return stock;
    }

}
