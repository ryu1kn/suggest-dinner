package com.example.suggest_dinner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String COMMAND_NAME = "suggest-dinner";
    private static final String OPT_NAME_RECIPE = "recipes";
    private static final String OPT_NAME_STOCK = "stock";

    public static void main(String... args) throws IOException {
        Options options = getCommandOptions();
        CommandLineParser parser = new DefaultParser();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            CommandLine cmdArgs = parser.parse(options, args);
            File recipeFile = new File(cmdArgs.getOptionValue(OPT_NAME_RECIPE));
            File stockFile = new File(cmdArgs.getOptionValue(OPT_NAME_STOCK));
            RecipeBook book = mapper.readValue(recipeFile, RecipeBook.class);
            Stock stock = mapper.readValue(stockFile, Stock.class);

            RecipeFinder finder = new RecipeFinder(book, stock);
            finder.find().stream()
                    .map(recipe -> recipe.getName())
                    .forEach(System.out::println);

        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(COMMAND_NAME, options);
        }
    }

    private static Options getCommandOptions() {
        Options options = new Options();
        options.addOption(Option.builder().longOpt(OPT_NAME_RECIPE).required().hasArg().build());
        options.addOption(Option.builder().longOpt(OPT_NAME_STOCK).required().hasArg().build());
        return options;
    }

}
