import java.awt.*;

public class Truck extends Car {
    private double truckBedPosition;
    private double truckBedPositionMax;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double truckBedPosition, double truckBedPositionMax) {
        super(nrDoors, enginePower, color, modelName);
        this.truckBedPosition = truckBedPosition;
        this.truckBedPositionMax = truckBedPositionMax;
    }

    public double getTruckBedPosition() {
        return truckBedPosition;
    }

    public double getTruckBedPositionMax() {
        return truckBedPositionMax;
    }
    @Override
    public void move() {if (truckBedPosition > 0) {
        throw new IllegalStateException("Cannot move while truck bed is raised!");}
        super.move();
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (truckBedPosition != 0) {
            throw new IllegalStateException("Cannot accelerate with raised truck bed.");}
        super.incrementSpeed(amount);
    }

    @Override
    protected void decrementSpeed(double amount) {
        if (truckBedPosition != 0) {
            throw new IllegalStateException("Cannot decelerate with raised truck bed.");}
        super.decrementSpeed(amount);
    }

    public void setTruckBedPosition(double newTruckBedPosition) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot change truck bed position while moving.");
        }
        if (newTruckBedPosition < 0 || newTruckBedPosition > truckBedPositionMax) {
            throw new IllegalArgumentException(String.format("Degree must be between 0 and %f.", truckBedPositionMax));
        }
        truckBedPosition = newTruckBedPosition;
    }
}
