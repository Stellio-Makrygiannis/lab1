package CarModel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class CarShop <T extends Car> {
    private List<T> currentCars;
    private final int maxCars;

    public CarShop(int maxCars) {
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>();
    }

    public boolean isShopFull() {
        return currentCars.size() >= maxCars;
    }

    public void addCar(T car) {
        if (isShopFull()) {
            throw new IllegalStateException("Shop is full.");
        }
        currentCars.add(car);
    }

    public T removeCar(T car) {
        int carIndex = currentCars.indexOf(car);
        if (carIndex != -1) {
            currentCars.remove(carIndex);
            return car;
        } else{
            throw new NoSuchElementException("No such car in the shop.");
        }

    }
}
