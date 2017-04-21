package hell.entities.items;

import hell.interfaces.Item;

/**
 * Created by vladix on 4/21/17.
 */
public class CommonItem extends BaseItem {

    public CommonItem(String name,
                      int strengthBonus,
                      int agilityBonus,
                      int intelligenceBonus,
                      int healthPointsBonus,
                      int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, healthPointsBonus, damageBonus);
    }

}
