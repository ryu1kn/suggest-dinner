package com.example.suggest_dinner;

import java.util.Collections;
import java.util.Map;

public class Stock {

    private int version = -1;
    private Map<String, Integer> ingredients = Collections.emptyMap();

    public void setVersion(int version) {
        this.version = version;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

}
