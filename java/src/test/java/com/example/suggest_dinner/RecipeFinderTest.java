package com.example.suggest_dinner;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RecipeFinderTest {

    @Test
    public void pickRecipeGivenEnoughIngredients() {
        Recipe recipe = buildRecipe("Beef Steak", ImmutableMap.of("beef", 300));
        RecipeBook book = buildRecipeBook(recipe);
        Stock stock = buildStock(ImmutableMap.of("beef", 300));
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Arrays.asList(recipe), finder.find());
    }

    @Test
    public void doesNotPickRecipeGivenNotEnoughIngredients() {
        Recipe recipe = buildRecipe("Beef Steak", ImmutableMap.of("beef", 300));
        RecipeBook book = buildRecipeBook(recipe);
        Stock stock = buildStock(ImmutableMap.of("beef", 100));
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Collections.emptyList(), finder.find());
    }

    @Test
    public void pickBeefSteakRecipeButNotPorkSteak() {
        Recipe beefSteak = buildRecipe("Beef Steak", ImmutableMap.of("beef", 300));
        Recipe porkSteak = buildRecipe("Pork Steak", ImmutableMap.of("pork", 300));
        RecipeBook book = buildRecipeBook(porkSteak, beefSteak);
        Stock stock = buildStock(ImmutableMap.of("beef", 300));
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Arrays.asList(beefSteak), finder.find());
    }

    @Test
    public void findNoRecipesIfNotEnoughIngredients() {
        Recipe beefSteak = buildRecipe("Beef Steak", ImmutableMap.of("beef", 300));
        RecipeBook book = buildRecipeBook(beefSteak);
        Stock stock = buildStock(Collections.emptyMap());
        RecipeFinder finder = new RecipeFinder(book, stock);

        assertEquals(Collections.emptyList(), finder.find());
    }

    private RecipeBook buildRecipeBook(Recipe... recipes) {
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(recipes));
        return book;
    }

    private Recipe buildRecipe(String name, Map<String, Integer> ingredients) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        return recipe;
    }

    private Stock buildStock(Map<String, Integer> ingredients) {
        Stock stock = new Stock();
        stock.setIngredients(ingredients);
        return stock;
    }

}
