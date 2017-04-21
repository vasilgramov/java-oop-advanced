package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by vladix on 4/21/17.
 */
public abstract class BaseHero implements Hero {

    private String name;

    private long initStr;
    private long initAgility;
    private long initIntelligence;
    private long initHP;
    private long initDMG;

    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;

    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;

        this.initStr = strength;
        this.initAgility = agility;
        this.initIntelligence = intelligence;
        this.initHP = hitPoints;
        this.initDMG = damage;

        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;

        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @Override
    public Collection<Item> getItems() {
        try {
            Field commonItems = HeroInventory.class.getDeclaredField("commonItems");
            commonItems.setAccessible(true);
            Map<String, Item> items = ((Map<String, Item>) commonItems.get(this.inventory));
            return items.values();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);

        updateHeroStats();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);

        updateHeroStats();
    }

    private void updateHeroStats() {
        this.strength = this.initStr + this.inventory.getTotalStrengthBonus();
        this.agility = this.initAgility + this.inventory.getTotalAgilityBonus();
        this.intelligence = this.initIntelligence + this.inventory.getTotalIntelligenceBonus();
        this.hitPoints = this.initHP + this.inventory.getTotalHitPointsBonus();
        this.damage = this.initDMG + this.inventory.getTotalDamageBonus();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hero: %s, Class: ", this.getName()) + "%s").append(System.lineSeparator())
                .append(String.format("HitPoints: %s, Damage: %s", this.getHitPoints(), this.getDamage())).append(System.lineSeparator())
                .append(String.format("Strength: %s", this.getStrength())).append(System.lineSeparator())
                .append(String.format("Agility: %s", this.getAgility())).append(System.lineSeparator())
                .append(String.format("Intelligence: %s", this.getIntelligence())).append(System.lineSeparator())
                .append(this.printItems());

        return builder.toString().trim();
    }

    private String printItems() {
        if (this.getItems().size() == 0) {
            return "Items: None";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("Items:").append(System.lineSeparator());
            for (Item item : this.getItems()) {
                builder.append(item.toString()).append(System.lineSeparator());
            }

            return builder.toString().trim();
        }
    }
}

