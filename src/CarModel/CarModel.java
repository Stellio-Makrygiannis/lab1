package CarModel;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class CarModel {

    private final Point volvoWorkshop = new Point(300, 50);
    private final CarSet carSet = new CarSet();
    private final CarSetAnimator carSetAnimator = new CarSetAnimator(carSet, volvoWorkshop);

    public void addCar(Car car) {
        carSet.addCar(car);
    }

    public Iterator<Car> carIterator() {
        return carSet.filterCars(_ -> true).iterator();
    }

    public CarSet getCarSet() {
        return carSet;
    }

    public Point getVolvoWorkshop() {
        return volvoWorkshop;
    }

    public void animate() { carSetAnimator.animate(); }
    public void addListener(ModelUpdateListener l) { carSetAnimator.addListener(l);}
}
