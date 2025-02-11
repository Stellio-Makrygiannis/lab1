import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CarTransport extends Truck {
    private Stack<Car> cars;
    private final static int maxCars = 3;
    private final static int maxEnginePower = 200;

    public CarTransport() {
        super(2, 250, Color.red, "BilTransport", 0, 10);
        this.cars = new Stack<Car>();
    }
    @Override
    public void setTruckBedPosition(double newTruckBedPosition) {
        // Ensure the truck is stationary
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot change truck bed position while moving.");
        }

        // Only allow two positions: 0 or 70
        if (newTruckBedPosition != 0 && newTruckBedPosition != getTruckBedPositionMax()) {
            throw new IllegalArgumentException("Truck bed position must be either 0 (up) or " + getTruckBedPositionMax() + " (down).");
        }

        // Call the parent method to actually set the position
        super.setTruckBedPosition(newTruckBedPosition);
    }

    /*
    IllegalStateException if the ramp is up, the transport is already full
    IllegalArgumentException if the car has too much enginePower of it's a CarTransport
     */
    public void addCar(Car car) {
        if (getTruckBedPosition() != 0 || cars.size() >= maxCars) {
            throw new IllegalStateException();
        }
        if (car.getEnginePower() > maxEnginePower || car.getClass() == CarTransport.class) {
            throw new IllegalArgumentException();
        }
        cars.push(car);
    }

    /*
    IllegalStateException if the ramp is up
    NoSuchElementException if the transport is empty
     */
    public Car removeCar() {
        if (getTruckBedPosition() != 0) {
            throw new IllegalStateException();
        }
        return cars.pop();
    }

    /*
    IllegalStateException if the speed is not zero
     */
    public void lowerRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        setTruckBedPosition(70);
    }

    /*
    IllegalStateException if the speed is not zero
     */
    public void raiseRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        setTruckBedPosition(0);
    }
}
