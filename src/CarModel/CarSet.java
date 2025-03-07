package CarModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarSet {
    public final List<Car> cars = new ArrayList<>();
    public static final int maxCars = 10;

    public void addCar(Car car) {
        if (cars.size() < maxCars) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void removeLastCar() {
        if (!cars.isEmpty()) {
            cars.removeLast();
        }
    }

    void move() {
        for (Car car : cars) {
            if (car.getCurrentSpeed() > 0) {
                car.move();
            }
        }
    }

    public List<Car> filterCars(Predicate<Car> predicate) {
        return cars.stream().filter(predicate).toList();
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    public void turboOn() {
        for (Car car : cars) {
            car.setTurboOn();
        }
    }

    public void turboOff() {
        for (Car car : cars) {
            car.setTurboOff();
        }
    }

    public void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    public void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    public void scaniaLiftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                try {
                    ((Scania) car).setTruckBedPosition(((Scania) car).getTruckBedPositionMax());
                } catch (Exception _) {
                    System.exit(1);
                }
            }
        }
    }

    public void scaniaLowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                try {
                    ((Scania) car).setTruckBedPosition(0);
                } catch (Exception _) {
                    System.exit(1);
                }
            }
        }
    }
}
