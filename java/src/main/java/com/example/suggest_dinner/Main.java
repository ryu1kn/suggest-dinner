package com.example.suggest_dinner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void main(String ...args) throws IOException {
        File recipeFile = new File(args[1]);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        RecipeBook book = mapper.readValue(recipeFile, RecipeBook.class);
        Ingredient beef = new Ingredient("beef");
        RecipePicker picker = new RecipePicker(book, Arrays.asList(beef));
        Optional<Recipe> found = picker.pick();
        String recipeName = found.isPresent() ? found.get().getName() : "";
        System.out.println(recipeName);
    }

}
