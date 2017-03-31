package tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;
import java.util.List;

public class AxeTests {

    @Test
    public void axeDurabilityTest() {
        Axe axe = new Axe(50, 1);
        Dummy dummy = new Dummy(5, 5, new ArrayList<Weapon>());

        axe.attack(dummy);

        Assert.assertTrue(axe.getDurabilityPoints() == 0);
    }

    @Test(expected = IllegalStateException.class)
    public void zeroDurabilityTest() {
        Axe axe = new Axe(50, 0);
        Dummy dummy = new Dummy(5, 5, new ArrayList<Weapon>());

        axe.attack(dummy);
    }
}
