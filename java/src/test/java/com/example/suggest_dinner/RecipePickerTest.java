package com.example.suggest_dinner;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecipePickerTest {

    @Test
    public void pickBeefSteakRecipe() {
        Ingredient beef = new Ingredient("Beef");
        Recipe recipe = new Recipe("Beef Steak", Arrays.asList(beef));
        RecipePicker rp = new RecipePicker(Arrays.asList(recipe), Arrays.asList(beef));
        assertEquals("Beef Steak", rp.pick().get().getName());
    }

    @Test
    public void pickBeefSteakRecipeButNotPorkSteak() {
        Ingredient beef = new Ingredient("beef");
        Ingredient pork = new Ingredient("pork");
        Recipe beefSteak = new Recipe("Beef Steak", Arrays.asList(beef));
        Recipe porkSteak = new Recipe("Pork Steak", Arrays.asList(pork));
        List<Recipe> recipes = Arrays.asList(porkSteak, beefSteak);
        RecipePicker rp = new RecipePicker(recipes, Arrays.asList(beef));

        assertEquals("Beef Steak", rp.pick().get().getName());
    }

}
