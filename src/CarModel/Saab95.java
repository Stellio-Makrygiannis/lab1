package CarModel;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    public final double turboFactor = 1.3;
    private Saab95State state;

    public Saab95() {

        super(2, 125, Color.red, "CarModel.Saab95");
        state = new Saab95StandardState(this);
    }

    public void setState(Saab95State state) {
        this.state = state;
    }

    @Override
    public void setTurboOn() {
        state.turboOn(this);
    }

    @Override
    public void setTurboOff() {
        state.turboOff(this);
    }

    @Override
    public double speedFactor() {
        return state.speedFactor(this);
    }
}