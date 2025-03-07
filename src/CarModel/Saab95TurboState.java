package CarModel;

public class Saab95TurboState implements Saab95State {
    private Saab95 saab95;

    public Saab95TurboState(Saab95 saab95) {
        this.saab95 = saab95;
    }

    @Override
    public void turboOn(Saab95 saab95) {
    }

    @Override
    public void turboOff(Saab95 saab) {
        saab95.setState(new Saab95StandardState(saab95));
    }

    @Override
    public double speedFactor(Saab95 saab) {
        return (saab.getEnginePower() * 0.01) * saab95.turboFactor;
    }
}
