package tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;

public class DummyTests {

    public static final int ATTACK_POINTS = 9999;

    @Test
    public void testDummyHealthWhenAttacked() {
        Dummy dummy = new Dummy(5, 5, new ArrayList<Weapon>());
        dummy.takeAttack(1);
        Assert.assertTrue(dummy.getHealth() == 4);

    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyWhenAttacked() {
        Dummy dummy = new Dummy(0, 5, new ArrayList<Weapon>());

        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDummyGiveXP() {
        Dummy dummy = new Dummy(0, 5, new ArrayList<Weapon>());

        Assert.assertTrue(dummy.giveExperience() == 5);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyGiveNoXP() {
        Dummy dummy = new Dummy(10, 5, new ArrayList<Weapon>());

        Assert.assertTrue(dummy.giveExperience() == 0);
    }
}
