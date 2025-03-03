import com.sun.jdi.VoidValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    //
    // Hmmm. maybe a separate list for each car type?
    ArrayList<Car> cars = new ArrayList<>();
    CarShop<Volvo240> volvoWorkshop = new CarShop<>(5);

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Car> cars_to_remove = new ArrayList<>();
            for (Car car : cars) {
                if (car.isMoving()) {
                    try {
                        car.move();
                    }
                    catch(Exception _) {
                        System.exit(1);
                    }
                    if (car.getCurrentPosition()[0] > 700) {
                        car.stopEngine();
                        car.turnRight();
                        car.turnRight();
                        car.startEngine();
                        car.setCurrentPosition(new double[]{700, car.getCurrentPosition()[1]});
                    } else if (car.getCurrentPosition()[0] < 0) {
                        car.stopEngine();
                        car.turnRight();
                        car.turnRight();
                        car.startEngine();
                        car.setCurrentPosition(new double[]{0, car.getCurrentPosition()[1]});
                    }
                }
                int x = (int) Math.round(car.getCurrentPosition()[0]);
                int y = (int) Math.round(car.getCurrentPosition()[1]);
                switch (car) {
                    case Volvo240 _ -> frame.drawPanel.move_volvo240(x, y);
                    case Saab95 _ -> frame.drawPanel.move_saab95(x, y);
                    case Scania _ -> frame.drawPanel.move_scania(x, y);
                    default -> {
                    }
                }
                if (car instanceof Volvo240) {
                    if (Math.abs(car.getCurrentPosition()[1] - frame.drawPanel.get_volvo_workshop_point().y) < 50 && Math.abs(car.getCurrentPosition()[0] - frame.drawPanel.get_volvo_workshop_point().x) < 50) {
                        volvoWorkshop.addCar((Volvo240) car);
                        cars_to_remove.add(car);
                    }
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            for (Car car : cars_to_remove) {
                cars.remove(car);
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void scaniaLiftBed() {
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

    void scaniaLowerBed() {
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
