/**
 * Fish class defines a Fish object.
 * @author Hyeokjin Jin
 * @version HW02 10/11/23
 */
public class Fish {
    protected final String name;
    protected Double length;
    protected Double weight;
    private static int totalFish;

    /**
     * Fish constructor that takes in name, length, and weight as parameters.
     * @param name The name of the Fish.
     * @param length The end to end length of the Fish.
     * @param weight The weight of the Fish.
     */
    public Fish(String name, Double length, Double weight) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Nemo";
        } else {
            this.name = name;
        }

        if (length == null || length.isNaN() || length.isInfinite() || length <= 0) {
            this.length = 8.0;
        } else {
            this.length = length;
        }

        if (weight == null || weight.isNaN() || weight.isInfinite() || weight <= 0) {
            this.weight = 2.0;
        } else {
            this.weight = weight;
        }
        totalFish += 1;
    }

    /**
     * Empty Fish constructor that no parameters and sets each parameter to a set default value.
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
    }

    /**
     * Deep copy constructor for the object Fish.
     * @param other Different Fish object that is deep copied.
     */
    public Fish(Fish other) {
        this(other.name, other.length, other.weight);
    }

    /**
     * Method that formats and returns a string containing the length of Fish into feet and inches.
     * @return String that contains the feet and inches of the Fish object.
     */
    public String formatLength() {
        return String.format("%d ft %.2f in",
                (int) (length / 12),
                (length % 12));
    }

    /**
     * Method that formats and returns a string containing the weight of Fish into pounds and ounces.
     * @return String that contains the pounds and ounces of the Fish object.
     */
    public String formatWeight() {
        return String.format("%d %s %.2f oz",
                (int) (weight / 16),
                ((int) (weight / 16) == 1 ? "lb" : "lbs"),
                (weight % 16));
    }

    /**
     * Override toString method that introduces the Fish object and says its length and weight.
     * @return Formatted string containing Fish's name, length, and weight.
     */
    @Override
    public String toString() {
        return String.format("I'm a talking fish named %s. My length is %s and my weight is %s.",
                name, formatLength(), formatWeight());
    }
}
