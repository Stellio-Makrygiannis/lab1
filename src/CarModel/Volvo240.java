package CarModel;

import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black, "CarModel.Volvo240");
    }

    @Override
    public double speedFactor(){
        return super.speedFactor() * trimFactor;
    }
}