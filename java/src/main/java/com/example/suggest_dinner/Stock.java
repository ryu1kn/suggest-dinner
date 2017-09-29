package com.example.suggest_dinner;

import java.util.Collections;
import java.util.List;

public class Stock {

    private int version = -1;
    private List<String> ingredients = Collections.emptyList();

    public void setVersion(int version) {
        this.version = version;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

}
