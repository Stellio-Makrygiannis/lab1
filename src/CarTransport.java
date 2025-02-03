import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Can't find a nice way to reuse Truck functionality atm.
public class CarTransport extends Car {
    private List<Car> cars;
    private boolean ramp_is_up;
    private final static int maxCars = 3;
    private final static int maxEnginePower = 200;

    public CarTransport() {
        super(2, 250, Color.red, "BilTransport");
        this.cars = new ArrayList<Car>();
        ramp_is_up = true;
    }

    @Override
    public void move() {
        if (!getIsRampUp()) {
            throw new IllegalStateException("Cannot move while the ramp is down.");
        }
        super.move();
        cars.forEach(car -> car.setCurrentPosition(getCurrentPosition()));
    }

    /*
    IllegalStateException if the ramp is up, the transport is already full
    IllegalArgumentException if the car has too much enginePower of it's a CarTransport
     */
    public void addCar(Car car) {
        if (ramp_is_up || cars.size() >= maxCars) {
            throw new IllegalStateException();
        }
        if (car.getEnginePower() > maxEnginePower || car.getClass() == CarTransport.class) {
            throw new IllegalArgumentException();
        }
        this.cars.add(car);
    }

    /*
    IllegalStateException if the ramp is up
    NoSuchElementException if the transport is empty
     */
    public Car removeCar() {
        if (ramp_is_up) {
            throw new IllegalStateException();
        }
        return cars.removeLast();
    }

    /*
    IllegalStateException if the speed is not zero
     */
    public void lowerRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        ramp_is_up = false;
    }

    /*
    IllegalStateException if the speed is not zero
     */
    public void raiseRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        ramp_is_up = true;
    }

    public boolean getIsRampUp() {
        return ramp_is_up;
    }
}
