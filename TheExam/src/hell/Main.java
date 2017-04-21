package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Hero> heroesByName = new LinkedHashMap<>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("Quit")) {
            String[] tokens = line.split("\\s+");
            String commandType = tokens[0];
            switch (commandType) {
                case "Hero": {
                    String heroName = tokens[1];
                    String heroType = tokens[2];
                    Hero hero = null;
                    switch (heroType) {
                        case "Barbarian":
                            hero = new Barbarian(heroName);
                            break;
                        case "Assassin":
                            hero = new Assassin(heroName);
                            break;
                        case "Wizard":
                            hero = new Wizard(heroName);
                            break;
                    }

                    heroesByName.put(heroName, hero);

                    System.out.println(String.format("Created %s - %s", heroType, heroName));
                    break;
                }
                case "Item": {
                    String itemName = tokens[1];
                    String toHeroName = tokens[2];
                    int str = Integer.parseInt(tokens[3]);
                    int agil = Integer.parseInt(tokens[4]);
                    int intelligence = Integer.parseInt(tokens[5]);
                    int hp = Integer.parseInt(tokens[6]);
                    int dmg = Integer.parseInt(tokens[7]);

                    Item item = new CommonItem(itemName, str, agil, intelligence, hp, dmg);
                    Hero hero = heroesByName.get(toHeroName);
                    hero.addItem(item);

                    System.out.println(String.format("Added item - %s to Hero - %s", itemName, toHeroName));
                    break;
                }
                case "Recipe": {
                    String itemName = tokens[1];
                    String toHeroName = tokens[2];
                    int str = Integer.parseInt(tokens[3]);
                    int agil = Integer.parseInt(tokens[4]);
                    int intelligence = Integer.parseInt(tokens[5]);
                    int hp = Integer.parseInt(tokens[6]);
                    int dmg = Integer.parseInt(tokens[7]);

                    List<String> requiredItems = new ArrayList<>();
                    for (int i = 8; i < tokens.length; i++) {
                        requiredItems.add(tokens[i]);
                    }

                    Recipe recipe = new RecipeItem(itemName, str, agil, intelligence, hp, dmg, requiredItems);
                    Hero hero = heroesByName.get(toHeroName);
                    hero.addRecipe(recipe);

                    System.out.println(String.format("Added recipe - %s to Hero - %s", itemName, toHeroName));
                    break;
                }
                case "Inspect":
                    String heroName = tokens[1];

                    Hero hero = heroesByName.get(heroName);
                    System.out.println(hero);
                    break;
            }

            line = in.nextLine();
        }

        final int[] count = {1};
        heroesByName.entrySet().stream()
                .sorted((h1, h2) -> {
                    long h1Stats = h1.getValue().getStrength() + h1.getValue().getAgility() + h1.getValue().getIntelligence();
                    long h2Stats = h2.getValue().getStrength() + h2.getValue().getAgility() + h2.getValue().getIntelligence();

                    if (h1Stats == h2Stats) {
                        h1Stats = h1.getValue().getHitPoints() + h1.getValue().getDamage();
                        h2Stats = h2.getValue().getHitPoints() + h2.getValue().getDamage();

                        return Long.compare(h2Stats, h1Stats);
                    }

                    return Long.compare(h2Stats, h1Stats);
                }).forEach(h -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(String.format("%s. %s: %s", count[0]++, h.getValue().getClass().getSimpleName(), h.getValue().getName())).append(System.lineSeparator())
                            .append(String.format("###HitPoints: %s", h.getValue().getHitPoints())).append(System.lineSeparator())
                            .append(String.format("###Damage: %s", h.getValue().getDamage())).append(System.lineSeparator())
                            .append(String.format("###Strength: %s", h.getValue().getStrength())).append(System.lineSeparator())
                            .append(String.format("###Agility: %s", h.getValue().getAgility())).append(System.lineSeparator())
                            .append(String.format("###Intelligence: %s", h.getValue().getIntelligence())).append(System.lineSeparator())
                            .append(String.format("###Items: %s", printItems(h.getValue().getItems())));

                    System.out.println(builder.toString());
        });

    }

    private static String printItems(Collection<Item> items) {
        if (items.size() == 0) {
            return "None";
        }

        List<String> itemsStr = new ArrayList<>();
        for (Item item : items) {
            itemsStr.add(item.getName());
        }

        return String.join(", ", itemsStr);
    }
}