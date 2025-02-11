import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestScaniaMethods {
    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTruckPositionToNegativeValueFails() {
        scania.setTruckBedPosition(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTruckPositionTooHighFails() {
        scania.setTruckBedPosition(10000.0);
    }

    @Test
    public void testGasWithNoAngle() {
        scania.gas(0.9);
    }

    @Test
    public void testBrakeWithNoAngle() {
        scania.brake(0.9);
    }

    @Test(expected = IllegalStateException.class)
    public void testGasWithAngle() {
        scania.setTruckBedPosition(35);
        scania.gas(0.9);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrakeWithAngle() {
        scania.setTruckBedPosition(35);
        scania.brake(0.9);
    }
}