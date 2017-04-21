package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vladix on 4/21/17.
 */
public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name,
                      int strengthBonus,
                      int agilityBonus,
                      int intelligenceBonus,
                      int healthPointsBonus,
                      int damageBonus,
                      List<String> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, healthPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }

}
