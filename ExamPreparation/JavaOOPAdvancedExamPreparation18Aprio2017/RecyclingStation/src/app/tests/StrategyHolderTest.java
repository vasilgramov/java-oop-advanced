package app.tests;

import app.models.processors.BurnableDisposalStrategy;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by vladix on 4/20/17.
 */
public class StrategyHolderTest {

    private StrategyHolder strategyHolder;

    @Before
    public void setUp() throws Exception {
        this.strategyHolder = new DefaultStrategyHolder();
    }

    @Test
    public void getDisposalStrategies_ShouldReturnEmptyCollection() {
        Map<Class, GarbageDisposalStrategy> disposalStrategies = this.strategyHolder.getDisposalStrategies();

        int expected = 0;
        Assert.assertEquals(expected, disposalStrategies.size());
    }

    @Test
    public void addStrategy_CheckIfItIsAdded() {
        this.strategyHolder.addStrategy(Burnable.class, new BurnableDisposalStrategy());

        int expected = 1;
        Assert.assertEquals(expected, this.strategyHolder.getDisposalStrategies().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStrategy_WithNullClass_ShouldThrowException() {
        this.strategyHolder.addStrategy(null, new BurnableDisposalStrategy());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStrategy_WithNullStrategy_ShouldThrowException() {
        this.strategyHolder.addStrategy(Burnable.class, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStrategy_AlreadyRegistered_ThrowException() {
        this.strategyHolder.addStrategy(Burnable.class, new BurnableDisposalStrategy());
        this.strategyHolder.addStrategy(Burnable.class, new BurnableDisposalStrategy());
    }

    @Test
    public void removeStrategy_ShouldRemove_CollectionEmpty() {
        this.strategyHolder.addStrategy(Burnable.class, new BurnableDisposalStrategy());
        this.strategyHolder.removeStrategy(Burnable.class);

        int expected = 0;
        int result = this.strategyHolder.getDisposalStrategies().size();
        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStrategy_NullAnnotationClass_ThrowException() {
        this.strategyHolder.removeStrategy(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStrategy_UnregisteredClass_ThrowException() {
        this.strategyHolder.removeStrategy(Burnable.class);
    }

}