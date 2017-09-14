package com.example.suggest_dinner;

import java.util.Arrays;

public class Main {

    public static void main(String ...args) {
        Recipe recipe = new Recipe("Beef Steak", Arrays.asList(new Ingredient("beef")));
        Command command = new Command(Arrays.asList(recipe));
        System.out.println(command.execute());
    }

}
