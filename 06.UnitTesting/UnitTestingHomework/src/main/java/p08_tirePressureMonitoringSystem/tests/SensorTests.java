package p08_tirePressureMonitoringSystem.tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p08_tirePressureMonitoringSystem.models.Sensor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SensorTests {

    @Test
    public void testSensorPSI() throws InvocationTargetException, IllegalAccessException {
        Sensor sensor = new Sensor();

        double psi = sensor.popNextPressurePsiValue();

        Assert.assertTrue(psi > 16);
    }


}
