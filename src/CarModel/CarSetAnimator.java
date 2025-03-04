package CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarSetAnimator {
        private final CarSet carSet;

        public CarSetAnimator(CarSet carSet) {
            this.carSet = carSet;
        }

        public void update() {
            carSet.move();

            // Check collisions
            for (Car car : carSet.filterCars(car -> car.getCurrentPosition()[0] > 700)) {
                // Hmmm... Maybe it's wrong to use the Car class directly instead of using it through th CarSet? But I'm not sure.
                car.stopEngine();
                car.turnRight();
                car.turnRight();
                car.startEngine();
                car.setCurrentPosition(new double[]{700, car.getCurrentPosition()[1]});
            }

            for (Car car : carSet.filterCars(car -> car.getCurrentPosition()[0] < 0)) {
                // Hmmm... Maybe it's wrong to use the Car class directly instead of using it through th CarSet? But I'm not sure.
                car.stopEngine();
                car.turnRight();
                car.turnRight();
                car.startEngine();
                car.setCurrentPosition(new double[]{0, car.getCurrentPosition()[1]});
            }
        }

        public void animate(){
            boolean running = true;
            while (running) {
                try {
                    Thread.sleep(50);
                    update();
                    notifyListeners();
                } catch (InterruptedException e) {
                    running = false;
                }
            }
        }

        private final List<ModelUpdateListener> listeners = new ArrayList<>();
        public void addListener(ModelUpdateListener l){
            listeners.add(l);
        }
        protected void notifyListeners(){
            for (ModelUpdateListener l : listeners)
                l.actOnModelUpdate();
        }
}
