package CarModel;

public class CarFactory {
    public static Car NewCar(String car) {
        return switch (car) {
            case "Volvo240" -> new Volvo240();
            case "Saab95" -> new Saab95();
            case "Scania" -> new Scania();
            default -> throw new IllegalArgumentException("No such car");
        };
    }
}
