package com.example.suggest_dinner;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class RecipePickerTest {

    @Test
    public void pickBeefSteakRecipe() {
        Ingredient beef = new Ingredient("Beef");
        Recipe recipe = new Recipe("Beef Steak", Collections.singletonList(beef));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Collections.singletonList(recipe));
        Stock stock = new Stock();
        stock.setIngredients(Arrays.asList("Beef"));
        RecipePicker rp = new RecipePicker(book, stock);

        assertEquals("Beef Steak", rp.pick().get().getName());
    }

    @Test
    public void pickBeefSteakRecipeButNotPorkSteak() {
        Ingredient beef = new Ingredient("beef");
        Ingredient pork = new Ingredient("pork");
        Recipe beefSteak = new Recipe("Beef Steak", Collections.singletonList(beef));
        Recipe porkSteak = new Recipe("Pork Steak", Collections.singletonList(pork));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(porkSteak, beefSteak));
        Stock stock = new Stock();
        stock.setIngredients(Arrays.asList("beef"));
        RecipePicker rp = new RecipePicker(book, stock);

        assertEquals("Beef Steak", rp.pick().get().getName());
    }

    @Test
    public void findNoRecipesIfNotEnoughIngredients() {
        Ingredient beef = new Ingredient("beef");
        Recipe beefSteak = new Recipe("Beef Steak", Collections.singletonList(beef));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Collections.singletonList(beefSteak));
        Stock stock = new Stock();
        RecipePicker rp = new RecipePicker(book, stock);

        assertEquals(Optional.empty(), rp.pick());
    }

}
