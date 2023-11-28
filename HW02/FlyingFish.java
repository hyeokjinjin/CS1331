import java.util.Random;
/**
 * FlyingFish class that extends the Fish class.
 * @author Hyeokjin Jin
 * @version HW02 10/11/23
 */
public class FlyingFish extends Fish {
    private int flightTime;

    /**
     * FlyingFish constructor that takes in name, length, weight, and flightTime and utilizes the parent constructor.
     * @param name Name of Fish.
     * @param length Length of Fish.
     * @param weight Weight of Fish.
     * @param flightTime Flight time of the Flying Fish
     */
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);
        if (flightTime > 0) {
            this.flightTime = flightTime;
        } else {
            this.flightTime = 30;
        }
    }

    /**
     * FlyingFish constructor without any parameters and defaults to set values.
     */
    public FlyingFish() {
        this("Gilbert", 12.0, 24.0, 36);
    }

    /**
     * Deep copy constructor for the FlyingFish objects.
     * @param other Different FlyingFish that is being deep copied.
     */
    public FlyingFish(FlyingFish other) {
        this(other.name, other.length, other.weight, other.flightTime);
    }

    /**
     * Method that calculates the power of the flying fish by multiplying the weight and flight time.
     * @return double representing the power of the flying fish.
     */
    public double calculatePower() {
        return (weight * flightTime);
    }

    /**
     * Method that prints out the name of the Flying Fish and how long Fish was flying for from a set range of numbers.
     */
    public void fly() {
        Random rand = new Random();
        System.out.printf("Woohoo! %s flew for %.2f seconds.%n",
                name, (rand.nextDouble() * -1) * flightTime + flightTime);
    }

    /**
     * Override method that adds additional information about the FlyingFish object to the parents toString method.
     * @return Formatted string with the FlyingFish object's flight time record and power level.
     */
    @Override
    public String toString() {
        return String.format("%s I'm a flying fish, and my flight time record is %d, so my power is %.2f",
                super.toString(), flightTime, calculatePower());
    }
}
