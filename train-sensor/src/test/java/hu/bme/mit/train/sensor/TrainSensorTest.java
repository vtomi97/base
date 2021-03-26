package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainUserImpl user;
    TrainController controller;
    TrainSensorImpl sensor;

    @Before
    public void before() {
        user = mock(TrainUserImpl.class);
        controller = mock(TrainController.class);
        sensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void SpeedTest() {
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(100);
        verify(user, times(1)).setAlarmState(false);
    }

    @Test
    public void MinusSpeedTest() {
        when(controller.getReferenceSpeed()).thenReturn(-10);
        sensor.overrideSpeedLimit(-6);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void OverSpeedTest() {
        when(controller.getReferenceSpeed()).thenReturn(300);
        sensor.overrideSpeedLimit(510);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void HalfSpeedTest() {
        when(controller.getReferenceSpeed()).thenReturn(300);
        sensor.overrideSpeedLimit(140);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void NewTest() {
        // TEST
    }
}
