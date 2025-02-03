import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    private final double turboFactor = 1.3;

    public Saab95() {

        super(2, 125, Color.red, "Saab95");
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        if (turboOn) {
            return super.speedFactor() * turboFactor;
        } else {
            return super.speedFactor();
        }
    }
}