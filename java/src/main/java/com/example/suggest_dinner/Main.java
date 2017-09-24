package com.example.suggest_dinner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Main {

    private static final String COMMAND_NAME = "suggest-dinner";
    private static final String OPT_NAME_RECIPE = "recipes";
    private static final String OPT_NAME_STOCK = "stock";

    public static void main(String ...args) throws IOException {
        Options options = new Options();
        options.addOption(Option.builder()
                .longOpt(OPT_NAME_RECIPE)
                .required()
                .hasArg()
                .build());
        options.addOption(Option.builder()
                .longOpt(OPT_NAME_STOCK)
                .required()
                .hasArg()
                .build());
        CommandLineParser parser = new DefaultParser();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            CommandLine cmdArgs = parser.parse(options, args);
            File recipeFile = new File(cmdArgs.getOptionValue(OPT_NAME_RECIPE));
            RecipeBook book = mapper.readValue(recipeFile, RecipeBook.class);
            File stockFile = new File(cmdArgs.getOptionValue(OPT_NAME_STOCK));
            Stock stock = mapper.readValue(stockFile, Stock.class);
            RecipePicker picker = new RecipePicker(book, stock);
            Optional<Recipe> found = picker.pick();
            String recipeName = found.isPresent() ? found.get().getName() : "";
            System.out.println(recipeName);
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(COMMAND_NAME, options);
        }
    }

}
