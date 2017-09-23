package com.example.suggest_dinner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Main {

    public static void main(String ...args) throws IOException {
        Options options = new Options();
        options.addOption(Option.builder()
                .longOpt("recipes")
                .required()
                .hasArg()
                .build());
        options.addOption(Option.builder()
                .longOpt("stock")
                .required()
                .hasArg()
                .build());
        CommandLineParser parser = new DefaultParser();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            CommandLine cmdArgs = parser.parse(options, args);
            File recipeFile = new File(cmdArgs.getOptionValue("recipes"));
            RecipeBook book = mapper.readValue(recipeFile, RecipeBook.class);
            File stockFile = new File(cmdArgs.getOptionValue("stock"));
            Stock stock = mapper.readValue(stockFile, Stock.class);
            RecipePicker picker = new RecipePicker(book, stock);
            Optional<Recipe> found = picker.pick();
            String recipeName = found.isPresent() ? found.get().getName() : "";
            System.out.println(recipeName);
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("suggest-dinner", options);
        }
    }

}
