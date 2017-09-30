
# Suggest Dinner

Trying to make this as a not too small but not big coding exercise
that I can solve with many languages and experiment things.

From the ingredients you have, suggest tonight's dinner

```sh
$ suggest-dinner --recipes recipes.yaml --stock stock.yaml
Beef steak
```

* stock.yaml

```yaml
version: 1
ingredients:
  - onion
  - beef
  - potato
```

* recipes.yaml

```yaml
version: 1
recipes:
  - name: Pot-au-feu
    ingredients:
      - onion
      - leek
      - pork
  - name: Beef steak
    ingredients:
      - beef
```

## Additional challenges

* Return not just one but all recipes that can be cooked
* Amount for ingredients (both stock and recipe)
* How many serves
* Ingredients can expire
* Each recipe has different difficulty
* Each recipe has different time to cook
* Read recipes and/or stock from different file formats (JSON, CSV, ...)
* Read recipes and/or stock from DB
* Make it a web service (provide API)
* Course menu: Entre, main, ...
* Food genre (Japanese, Thai, French, ...)
* Ingredients at hand, ingredients that can buy (with cost)
* Data migration (schema change)
* Provide a command if certain recipe can be cooked, if not, tell why
