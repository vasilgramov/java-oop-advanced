package hell.entities.miscellaneous;

import hell.entities.items.CommonItem;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<String, Item>();
        this.recipeItems = new LinkedHashMap<String, Recipe>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getStrengthBonus()).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getAgilityBonus()).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getIntelligenceBonus()).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getHitPointsBonus()).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getDamageBonus()).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }

        this.commonItems.put(item.getName(), item);

        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("Recipe is null");
        }

        this.recipeItems.put(recipe.getName(), recipe);

        this.checkRecipes();
    }

    private void checkRecipes() {
        List<Recipe> toBeRemoved = new ArrayList<>();

        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());

            long count = 0;
            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    count++;
                }
            }

            if (count == requiredItems.size()) {
                this.combineRecipe(recipe);
                toBeRemoved.add(recipe);
            }
        }

        for (Recipe recipe : toBeRemoved) {
            this.recipeItems.remove(recipe.getName());
        }
    }

    private void combineRecipe(Recipe recipe) {
        int str = recipe.getStrengthBonus();
        int agility = recipe.getAgilityBonus();
        int intelligence = recipe.getIntelligenceBonus();
        int hitpoints = recipe.getHitPointsBonus();
        int damage = recipe.getDamageBonus();

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        Item newItem = new CommonItem(recipe.getName(),
                str,
                agility,
                intelligence,
                hitpoints,
                damage);

        this.commonItems.put(newItem.getName(), newItem);
    }

}