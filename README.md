
# Suggest Dinner

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
  - name: pot-au-feu
    ingredients:
      - onion
      - leek
      - pork
  - name: Beef steak
    ingredients:
      - beef
```

## Additional challenges

* Amount for ingredients (both stock and recipe)
* Ingredients can expire
* Each recipe has different difficulty
* Each recipe has different time to cook
* Read recipes from DB
* Make it a web service (provide API)
* Course menu: Entre, main, ...
* Food genre (Japanese, Thai, French, ...)
* Ingredients at hand, ingredients that can buy (with cost)
* Data migration (schema change)
