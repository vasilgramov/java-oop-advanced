package tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

import java.util.Random;

public class HeroTests {

    public static final int ATTACK = 10;
    public static final int DURABILITY = 10;
    public static final int EXPERIENCE = 5;

    @Test
    public void heroGainsEPFromDeadTarget() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Hero", mockedWeapon);

        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(EXPERIENCE);

        hero.attack(mockedTarget, new RandomProvider.Implementation(new Random()));

        Assert.assertEquals(EXPERIENCE, hero.getExperience());
    }
}
