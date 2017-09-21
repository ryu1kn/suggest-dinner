package com.example.suggest_dinner;

public class Ingredient {

    private final String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Ingredient && this.name.equals(((Ingredient)other).name);
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/16069106/how-to-compare-two-java-objects
        return 37 + name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

}
