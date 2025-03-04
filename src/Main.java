import CarModel.Saab95;
import CarModel.Scania;
import CarModel.Volvo240;
import CarView.CarView;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //
        cm.carSet.addCar(new Volvo240());
        cm.carSet.addCar(new Saab95());
        cm.carSet.addCar(new Scania());

        for (int i = 0; i < cm.carSet.cars.size(); i++) {
            cm.carSet.cars.get(i).setCurrentPosition(new double[]{0, 100 * i});
            cm.carSet.cars.get(i).turnLeft();
        }

        // Start a new view and send a reference of self
        cm.frame = new CarView("CarSim 1.0", cm);

        // Start the timer
        cm.timer.start();
    }
}
