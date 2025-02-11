import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestTruckMethods {
    private Truck truck;

    @Before
    public void init() {
        truck = new Truck();
    }

    @Test
    public void testSetTruckPositionToZero() {
        truck.setTruckBedPosition(0);
        assertEquals(0.0, truck.getAngle());
    }

    @Test
    public void testSetTruckPositionToAValue() {
        truck.setTruckBedPosition(30);
        assertEquals(30.0, truck.getAngle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTruckPositionToNegativeValueFails() {
        truck.setTruckBedPosition(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTruckPositionTooHighFails() {
        truck.setTruckBedPosition(10000.0);
    }

    @Test
    public void testGasWithNoAngle() {
        truck.gas(0.9);
    }

    @Test
    public void testBrakeWithNoAngle() {
        truck.brake(0.9);
    }

    @Test(expected = IllegalStateException.class)
    public void testGasWithAngle() {
        truck.setTruckBedPosition(35);
        truck.gas(0.9);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrakeWithAngle() {
        truck.setTruckBedPosition(35);
        truck.brake(0.9);
    }
}