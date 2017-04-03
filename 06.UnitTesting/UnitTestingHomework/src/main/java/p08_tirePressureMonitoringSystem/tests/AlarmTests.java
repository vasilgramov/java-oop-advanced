package p08_tirePressureMonitoringSystem.tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p08_tirePressureMonitoringSystem.models.Alarm;
import p08_tirePressureMonitoringSystem.models.Sensor;

import java.lang.reflect.Field;

public class AlarmTests {

    @Test
    public void alarmShouldBeOFF() throws NoSuchFieldException, IllegalAccessException {
        Sensor mockedSenor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSenor.popNextPressurePsiValue()).thenReturn(17.5);

        Alarm alarm = new Alarm();

        Field sensor = Alarm.class.getDeclaredField("sensor");
        sensor.setAccessible(true);

        sensor.set(alarm ,mockedSenor);

        alarm.check();

        Assert.assertEquals(false, alarm.getAlarmOn());
    }

    @Test
    public void turningAlarmON() throws NoSuchFieldException, IllegalAccessException {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(22.0);

        Alarm alarm = new Alarm();

        Field sensor = Alarm.class.getDeclaredField("sensor");
        sensor.setAccessible(true);

        sensor.set(alarm, mockedSensor);

        alarm.check();

        Assert.assertEquals(true, alarm.getAlarmOn());
    }

}
