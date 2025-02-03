import java.awt.*;

public class Truck extends Car {
    private double truckBedPosition;
    private final static double truckBedPositionMax = 70.0;

    public Truck(){
        super(2, 250, Color.white, "Scania");

        this.truckBedPosition = 0;
    }

    @Override
    public void move() {
        if (truckBedPosition > 0) {
            throw new IllegalStateException("Cannot move while truck bed is raised!");
        }
        super.move();
    }

    /*
    IllegalStateException if the current angle is not zero
     */
    @Override
    protected void incrementSpeed(double amount){
        if (truckBedPosition != 0) {
            throw new IllegalStateException();
        }
        super.incrementSpeed(amount);
    }

    /*
    IllegalStateException if the current angle is not zero
     */
    @Override
    protected void decrementSpeed(double amount){
        if (truckBedPosition != 0) {
            throw new IllegalStateException();
        }
        super.incrementSpeed(amount);
    }

    /*
    IllegalStateException if the current speed is not zero
     */
    void setTruckBedPosition(double newTruckBedPosition) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot change truck be position while moving.");
        }
        if (newTruckBedPosition < 0 || newTruckBedPosition > truckBedPositionMax) {
            throw new IllegalArgumentException(String.format("Degree must be between 0 and %f.", truckBedPosition));
        }
        truckBedPosition = newTruckBedPosition;
    }

    double getAngle() {
        return this.truckBedPosition;
    }
}
