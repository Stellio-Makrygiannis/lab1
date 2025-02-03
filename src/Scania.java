import java.awt.*;

public class Scania extends Car {
    private double truckBedPosition = 0; // Degrees, initially 0

    public Scania() {
        super(2, 100, Color.white, "Scania");
    }

    public double getTruckBedPosition() {
        return truckBedPosition;
    }

    public void changeTruckBedPosition(double degree) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot change truck bed position while moving!");
        }
        if (degree < 0 || degree > 70) {
            throw new IllegalArgumentException("Degree must be between 0 and 70.");
        }
        truckBedPosition = degree;
    }

    @Override
    public void startEngine() {
        if (truckBedPosition > 0) {
            throw new IllegalStateException("Cannot start engine while truck bed is raised!");
        }
        super.startEngine();
    }

    @Override
    public void move() {
        if (truckBedPosition > 0) {
            throw new IllegalStateException("Cannot move while truck bed is raised!");
        }
        super.move();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
