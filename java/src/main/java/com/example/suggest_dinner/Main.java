package com.example.suggest_dinner;

import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void main(String ...args) {
        Ingredient beef = new Ingredient("beef");
        Recipe beefSteak = new Recipe("Beef Steak", Arrays.asList(beef));
        RecipePicker picker = new RecipePicker(Arrays.asList(beefSteak), Arrays.asList(beef));
        Optional<Recipe> found = picker.pick();
        String recipeName = found.isPresent() ? found.get().getName() : "";
        System.out.println(recipeName);
    }

}
