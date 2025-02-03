import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestScaniaMethods {
    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testAngleIncreaseWithNoSpeed() {
        scania.increaseAngle();
        assertTrue(scania.getAngle() > 0);
    }

    @Test
    public void testAngleDecrementWithSpeed() {
        scania.increaseAngle();
        scania.decrementAngle();
        assertEquals(scania.getAngle(), 0.0);
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
        scania.increaseAngle();
        scania.gas(0.9);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrakeWithAngle() {
        scania.increaseAngle();
        scania.brake(0.9);
    }
}
