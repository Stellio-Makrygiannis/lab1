public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setCurrentPosition(new double[]{0, 100 * i});
            cc.cars.get(i).turnLeft();
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
}
