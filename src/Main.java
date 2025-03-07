import CarModel.*;
import CarView.CarView;
import com.sun.source.tree.NewArrayTree;

import java.awt.*;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarModel carModel = new CarModel();

        carModel.addCar(CarFactory.newVolvo());
        carModel.addCar(CarFactory.newSaab95());
        carModel.addCar(CarFactory.newScania());

        int i = 0;
        Iterator<Car> carIterator = carModel.carIterator();
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            car.setCurrentPosition(new double[]{0, 100 * i});
            car.turnLeft();
            i += 1;
        }

        // Start a new view and send a reference of self
        CarView carView = new CarView(carModel.getCarSet(), carModel.getVolvoWorkshop());
        carModel.addListener(carView);
        carModel.animate();
    }
}
