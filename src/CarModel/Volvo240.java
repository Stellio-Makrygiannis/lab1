package CarModel;

import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black, "CarModel.Volvo240");
    }

    @Override
    protected double speedFactor(){
        return super.speedFactor() * trimFactor;
    }
}