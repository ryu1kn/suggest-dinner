package com.example.suggest_dinner;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class RecipePickerTest {

    @Test
    public void pickBeefSteakRecipe() {
        Ingredient beef = new Ingredient("Beef");
        Recipe recipe = new Recipe("Beef Steak", Arrays.asList(beef));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(recipe));
        RecipePicker rp = new RecipePicker(book, Arrays.asList(beef));

        assertEquals("Beef Steak", rp.pick().get().getName());
    }

    @Test
    public void pickBeefSteakRecipeButNotPorkSteak() {
        Ingredient beef = new Ingredient("beef");
        Ingredient pork = new Ingredient("pork");
        Recipe beefSteak = new Recipe("Beef Steak", Arrays.asList(beef));
        Recipe porkSteak = new Recipe("Pork Steak", Arrays.asList(pork));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(porkSteak, beefSteak));
        RecipePicker rp = new RecipePicker(book, Arrays.asList(beef));

        assertEquals("Beef Steak", rp.pick().get().getName());
    }

    @Test
    public void findNoRecipesIfNotEnoughIngredients() {
        Ingredient beef = new Ingredient("beef");
        Recipe beefSteak = new Recipe("Beef Steak", Arrays.asList(beef));
        RecipeBook book = new RecipeBook();
        book.setRecipes(Arrays.asList(beefSteak));
        RecipePicker rp = new RecipePicker(book, Arrays.asList());

        assertEquals(Optional.empty(), rp.pick());
    }

}
