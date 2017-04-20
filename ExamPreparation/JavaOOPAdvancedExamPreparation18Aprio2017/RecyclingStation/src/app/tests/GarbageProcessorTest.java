package app.tests;
import app.models.wastes.BurnableGarbage;
import app.models.wastes.RecyclableGarbage;
import app.models.wastes.StorableGarbage;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vladix on 4/20/17.
 */
public class GarbageProcessorTest {

    private StrategyHolder strategyHolder;
    private GarbageProcessor garbageProcessor;

    @Before
    public void setup() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewGarbageProcessor_WithNullStrategyHolder_ThrowException() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }

    @Test
    public void testGetStrategy_StrategyHolder_ShouldReturnTheSameReference() {
        StrategyHolder strategyHolder = this.garbageProcessor.getStrategyHolder();
        Assert.assertEquals(this.strategyHolder, strategyHolder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessWaste_WithNull_ShouldThrowException() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        this.garbageProcessor.processWaste(null);
    }

    @Test
    public void testProcessWaste_WithCorrectGarbage_Burnable() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ProcessingData expected = new DefaultProcessingData(3808.8, 0.0);
        ProcessingData processingData = this.garbageProcessor.processWaste(new BurnableGarbage("69", 69, 69));

        Assert.assertEquals(processingData.getEnergyBalance(), expected.getEnergyBalance(), 0);
        Assert.assertEquals(processingData.getCapitalBalance(), expected.getCapitalBalance(), 0);
    }

    @Test
    public void testProcessWaste_WithCorrectGarbage_Storable() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ProcessingData expected = new DefaultProcessingData(-618.93, -3094.65);
        ProcessingData processingData = this.garbageProcessor.processWaste(new StorableGarbage("69", 69, 69));

        Assert.assertEquals(processingData.getEnergyBalance(), expected.getEnergyBalance(), 0);
        Assert.assertEquals(processingData.getCapitalBalance(), expected.getCapitalBalance(), 0);
    }

    @Test
    public void testProcessWaste_WithCorrectGarbage_Recyclable() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ProcessingData expected = new DefaultProcessingData(-2380.5, 27600.0);
        ProcessingData processingData = this.garbageProcessor.processWaste(new RecyclableGarbage("69", 69, 69));

        Assert.assertEquals(processingData.getEnergyBalance(), expected.getEnergyBalance(), 0);
        Assert.assertEquals(processingData.getCapitalBalance(), expected.getCapitalBalance(), 0);
    }

}
