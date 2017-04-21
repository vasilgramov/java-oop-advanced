package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladix on 4/21/17.
 */
public class InventoryTests {

    private Inventory inventory;
    private Item commonItem;
    private Recipe recipeItem;

    @Before
    public void setUp() {
        this.inventory = Mockito.mock(Inventory.class);

        this.commonItem = Mockito.mock(Item.class);
        Mockito.when(this.commonItem.getName()).thenReturn("asd");
        Mockito.when(this.commonItem.getStrengthBonus()).thenReturn(69);
        Mockito.when(this.commonItem.getAgilityBonus()).thenReturn(69);
        Mockito.when(this.commonItem.getIntelligenceBonus()).thenReturn(69);
        Mockito.when(this.commonItem.getHitPointsBonus()).thenReturn(69);
        Mockito.when(this.commonItem.getDamageBonus()).thenReturn(69);

        List<String> requirements = new ArrayList<>();
        requirements.add("asd");
        this.recipeItem = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItem.getStrengthBonus()).thenReturn(123);
        Mockito.when(this.recipeItem.getAgilityBonus()).thenReturn(123);
        Mockito.when(this.recipeItem.getIntelligenceBonus()).thenReturn(123);
        Mockito.when(this.recipeItem.getHitPointsBonus()).thenReturn(123);
        Mockito.when(this.recipeItem.getDamageBonus()).thenReturn(123);
        Mockito.when(this.recipeItem.getRequiredItems()).thenReturn(requirements);
    }

    @Test
    public void testGetTotalStrengthBonusWithNoItems() {
        long totalStrengthBonus = this.inventory.getTotalStrengthBonus();

        long expected = 0;

        Assert.assertEquals("Damage must be 0", expected, totalStrengthBonus);
    }

    @Test
    public void testGetTotalAgilityBonusWithNoItems() {
        long totalStrengthBonus = this.inventory.getTotalAgilityBonus();

        long expected = 0;

        Assert.assertEquals("Damage must be 0", expected, totalStrengthBonus);
    }

    @Test
    public void testGetTotalIntelligenceBonusWithNoItems() {
        long totalStrengthBonus = this.inventory.getTotalIntelligenceBonus();

        long expected = 0;

        Assert.assertEquals("Damage must be 0", expected, totalStrengthBonus);
    }

    @Test
    public void testGetTotalHitPointsBonusWithNoItems() {
        long totalStrengthBonus = this.inventory.getTotalHitPointsBonus();

        long expected = 0;

        Assert.assertEquals("Damage must be 0", expected, totalStrengthBonus);
    }

    @Test
    public void testGetTotalDamageBonusWithNoItems() {
        long totalStrengthBonus = this.inventory.getTotalDamageBonus();

        long expected = 0;

        Assert.assertEquals("Damage must be 0", expected, totalStrengthBonus);
    }

    @Test
    public void testAddingCommonItemShouldIncreaseStrengthBonus() {
        long expected = 69;

        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);

        Assert.assertEquals(expected, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testAddingCommonItemShouldIncreaseAgilityBonus() {
        long expected = 69;

        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);

        Assert.assertEquals(expected, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void testAddingCommonItemShouldIncreaseIntelligenceBonus() {
        long expected = 69;

        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);

        Assert.assertEquals(expected, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testAddingCommonItemShouldIncreaseHitPointsBonus() {
        long expected = 69;

        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);

        Assert.assertEquals(expected, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testAddingCommonItemShouldIncreaseDamageBonus() {
        long expected = 69;

        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);

        Assert.assertEquals(expected, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void testAddingRecipeItemShouldNotIncreaseStrengthBonus() {
        long expected = 123;

        this.inventory = new HeroInventory();
        this.inventory.addRecipeItem(this.recipeItem);

        Assert.assertEquals(expected, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testAddingNewRecipeItemShouldNotIncreaseStrength() {
        this.inventory = new HeroInventory();
        this.inventory.addRecipeItem(this.recipeItem);

        long expected = 123;

        long totalStrengthBonus = this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(expected, totalStrengthBonus);
    }

    @Test
    public void testCreatingRecipeItem() {
        this.inventory = new HeroInventory();
        this.inventory.addCommonItem(this.commonItem);
        this.inventory.addRecipeItem(this.recipeItem);

        long expected = 123;
        long totalDamageBonus = this.inventory.getTotalDamageBonus();
        Assert.assertEquals(expected, totalDamageBonus);
    }



}
