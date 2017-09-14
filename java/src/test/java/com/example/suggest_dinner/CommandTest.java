package com.example.suggest_dinner;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Test
    public void returnRecipeName() {
        Recipe recipe = new Recipe("Beef Steak", Arrays.asList());
        Command c = new Command(Arrays.asList(recipe));
        assertEquals("Beef Steak", c.execute());
    }

    @Test
    public void returnDifferentRecipeName() {
        Recipe recipe = new Recipe("Thai Curry", Arrays.asList());
        Command c = new Command(Arrays.asList(recipe));
        assertEquals("Thai Curry", c.execute());
    }

}
