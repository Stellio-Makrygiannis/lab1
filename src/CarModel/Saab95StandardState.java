package CarModel;

public class Saab95StandardState implements Saab95State {
    private Saab95 saab95;

    public Saab95StandardState(Saab95 saab95) {
        this.saab95 = saab95;
    }

    @Override
    public void turboOn(Saab95 saab95) {
        saab95.setState(new Saab95TurboState(saab95));
    }

    @Override
    public void turboOff(Saab95 saab) {
    }

    @Override
    public double speedFactor(Saab95 saab) {
        return saab.getEnginePower() * 0.01;
    }
}



