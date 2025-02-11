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
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot change truck bed position while moving.");
        }

        if (newTruckBedPosition != 0 && newTruckBedPosition != getTruckBedPositionMax()) {
            throw new IllegalArgumentException("Truck bed position must be either 0 (up) or " + getTruckBedPositionMax() + " (down).");
        }

        super.setTruckBedPosition(newTruckBedPosition);
    }

    public void addCar(Car car) {
        if (getTruckBedPosition() == 0 || cars.size() >= maxCars) {
            throw new IllegalStateException();
        }
        if (car.getEnginePower() > maxEnginePower || car.getClass() == CarTransport.class) {
            throw new IllegalArgumentException();
        }
        cars.push(car);
    }

    public Car removeCar() {
        if (getTruckBedPosition() != 0) {
            throw new IllegalStateException();
        }
        return cars.pop();
    }

    public void lowerRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        setTruckBedPosition(10);
    }

    public void raiseRamp() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        setTruckBedPosition(0);
    }
}
