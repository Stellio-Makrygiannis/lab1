import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import static junit.framework.TestCase.assertTrue;

public class TestCarTransport {
    private CarTransport transport;

    @Before
    public void init() {
        transport = new CarTransport();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotAddTransport() {
        CarTransport transport2 = new CarTransport();
        transport.lowerRamp();
        transport.addCar(transport2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCarWithTooMuchEnginePower() {
        class LargeCar extends Car {
            public LargeCar() {
                super(10, 9999, Color.black, "Large Car");
            }
        }

        LargeCar large_car = new LargeCar();
        transport.lowerRamp();
        transport.addCar(large_car);
    }

    @Test
    public void testAddCarWithReasonableEnginePower() {
        Saab95 saab = new Saab95();
        transport.lowerRamp();
        transport.addCar(saab);
    }

    @Test
    public void testAddThreeCars() {
        Saab95 car1 = new Saab95();
        Saab95 car2 = new Saab95();
        Volvo240 car3 = new Volvo240();

        transport.lowerRamp();
        transport.addCar(car1);
        transport.addCar(car2);
        transport.addCar(car3);
    }

    @Test (expected = IllegalStateException.class)
    public void testAddTooManyCars() {
        transport.lowerRamp();
        for (int i = 0; i < 100; i ++) {
            transport.addCar(new Saab95());
        }
    }

    @Test (expected = IllegalStateException.class)
    public void testCannotAddCarWhileRampIsUp() {
        transport.raiseRamp();
        transport.addCar(new Saab95());
    }

    @Test (expected = IllegalStateException.class)
    public void testCannotMoveWithLoweredRamp() {
        transport.lowerRamp();
        transport.move();
    }

}