import CarModel.Saab95;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestGasAndBreak {
    private Saab95 car;

    @Before
    public void init() {
        car = new Saab95();
    }

    @Test
    public void testGasDoesNotSlowsCar() {
        double speed = car.getCurrentSpeed();
        car.gas(1.0);
        System.out.println(car.getCurrentSpeed());
        assertTrue(speed <= car.getCurrentSpeed());
    }

    @Test
    public void testBrakeDoesNotSpeedupCar() {
        double speed = car.getCurrentSpeed();
        car.brake(1.0);
        assertTrue(speed >= car.getCurrentSpeed());
    }

    @Test
    public void testSpeedDoesNotExceedEnginePower() {
        for (int i = 0; i < 100; i++) {
            car.gas(1.0);
        }
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
    }

    @Test
    public void testSpeedDoesNotGoBelowZero() {
        for (int i = 0; i < 100; i++) {
            car.brake(1.0);
        }
        assertTrue(car.getCurrentSpeed() >= 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGasArgumentAboveOneFails() {
        car.gas(1.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGasArgumentBelowZeroFails() {
        car.gas(-0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBrakeArgumentAboveOneFails() {
        car.brake(1.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBrakeArgumentBelowZeroFails() {
        car.brake(-0.1);
    }
}