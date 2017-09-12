
# Suggest Dinner

From the ingredients you have, suggest tonight's dinner

```sh
$ suggest-dinner --recipes recipes.yaml --ingredients ingredients.yaml
Beef steak
```

* ingredients.yaml

```yaml
ingredients:
  - name: onion
    amount: 3
    expire: 2017-09-12
  - name: beef
    amount: 100g
  - name: potato
    amount: 5
```

* recipes.yaml

```yaml
recipes:
  - name: pot-au-feu
    genre: french
    difficulty: low
    time: 120min
  - name: Thai curry
    genre: thai
    difficulty: medium
    time: 100min
  - name: Beef steak
    genre: ?
    difficulty: medium
    time: 10min
```
