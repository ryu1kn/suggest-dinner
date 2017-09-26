package com.example.suggest_dinner;

import java.util.Optional;

public class RecipeFinder {

    private final RecipeBook book;
    private final Stock stock;

    public RecipeFinder(RecipeBook book, Stock stock) {
        this.book = book;
        this.stock = stock;
    }

    public Optional<Recipe> find() {
        return book.getRecipes().stream()
                .filter(recipe -> recipe.canCookWith(stock.getIngredients()))
                .findFirst();
    }

}
