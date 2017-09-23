package com.example.suggest_dinner;

import java.util.Optional;

public class RecipePicker {

    private final RecipeBook book;
    private final Stock stock;

    public RecipePicker(RecipeBook book, Stock stock) {
        this.book = book;
        this.stock= stock;
    }

    public Optional<Recipe> pick() {
        return book.getRecipes().stream()
                .filter(recipe -> recipe.canCookWith(stock.getIngredients()))
                .findFirst();
    }

}
