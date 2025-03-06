package CarModel;

public class CarFactory {
    public static Car newVolvo() {
        return new Volvo240();
    }

    public static Car newSaab95() {
        return new Saab95();
    }

    public static Car newScania() {
        return new Scania();
    }
}
