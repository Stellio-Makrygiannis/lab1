import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private int[] currentPosition = {0,0};
    private int[] currentDirection = {0,1};

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();

    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public int[] getcurrentPosition(){
        return currentDirection;
    }

    public int[] getcurrentDirection(){
        return currentDirection;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void move() {
        currentPosition[0] += currentDirection[0] * getCurrentSpeed();
        currentPosition[1] += currentDirection[1] * getCurrentSpeed();
    }

    @Override
    public void turnLeft() {
        int temp = currentDirection[0];
        currentDirection[0] = -currentDirection[1];
        currentDirection[1] = temp;
    }

    @Override
    public void turnRight() {
        int temp = currentDirection[0];
        currentDirection[0] = currentDirection[1];
        currentDirection[1] = -temp;
       
    }

    /* Increases the current speed of the car.
    @param amount the amount to speed up.
    @throws IllegalArgumentException if the parameter is not in the range 0.0 to 1.0 (inclusive)
     */
    public void gas(double amount){
        if (amount > 1.0 || amount < 0.0) {
            throw new IllegalArgumentException("amounts outside [0.0,1.0] are not allowed");
        }
        incrementSpeed(amount);
    }
    
    /* Decreases the current speed of the car.
    @param amount the amount to slow down
    @throws IllegalArgumentException if the parameter is not in the range 0.0 to 1.0 (inclusive)
     */
    public void brake(double amount){
        if (amount > 1.0 || amount < 0.0) {
            throw new IllegalArgumentException("amounts outside [0.0,1.0] are not allowed");
        }
        decrementSpeed(amount);
    }
}