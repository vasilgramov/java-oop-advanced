package hell.interfaces;

public interface Inventory {

    long getTotalStrengthBonus();

    long getTotalAgilityBonus();

    long getTotalIntelligenceBonus();

    long getTotalHitPointsBonus();

    long getTotalDamageBonus();

    void addCommonItem(Item item) throws IllegalArgumentException;

    void addRecipeItem(Recipe recipe);

}