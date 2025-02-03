import java.awt.*;

public class Scania extends Car {
    private double angle;
    private static double angleSpeed = 10.0;
    private static double angleMax = 70.0;

    public Scania(){
        super(2, 250, Color.white, "Scania");

        this.angle = 0;
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    /*
    IllegalStateException if the current angle is not zero
     */
    @Override
    protected void incrementSpeed(double amount){
        if (angle != 0) {
            throw new IllegalStateException();
        }
        super.incrementSpeed(amount);
    }

    /*
    IllegalStateException if the current angle is not zero
     */
    @Override
    protected void decrementSpeed(double amount){
        if (angle != 0) {
            throw new IllegalStateException();
        }
        super.incrementSpeed(amount);
    }

    /*
    IllegalStateException if the current speed is not zero
     */
    void increaseAngle() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        this.angle = Math.min(angleMax, this.angle + angleSpeed);
    }

    double getAngle() {
        return this.angle;
    }

    /*
    IllegalStateException if the current speed is not zero
     */
    void decrementAngle() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalStateException();
        }
        this.angle = Math.max(0.0, this.angle - angleSpeed);
    }
}
