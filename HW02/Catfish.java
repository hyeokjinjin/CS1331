/**
 * Catfish class that extends the Fish class.
 * @author Hyeokjin Jin
 * @version HW02 10/11/23
 */
public class Catfish extends Fish {
    private Double whiskerLength;

    /**
     * Catfish object constructor that utilizes parent constructor found in Fish class.
     * @param name Name of Fish object.
     * @param length End to end length of the Fish object.
     * @param weight Weight of the Fish object.
     * @param whiskerLength Whisker length of the Fish object.
     */
    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        if (whiskerLength == null || whiskerLength.isNaN() || whiskerLength.isInfinite() || whiskerLength <= 0) {
            this.whiskerLength = 8.0;
        } else {
            this.whiskerLength = whiskerLength;
        }
    }

    /**
     * Constructor that does not take in any parameters and defaults to set values.
     */
    public Catfish() {
        this("Bubba", 52.0, 720.0, 5.0);
    }

    /**
     * Deep copy constructor of Catfish objects.
     * @param other Different Catfish object that this Catfish object will deep copy.
     */
    public Catfish(Catfish other) {
        this(other.name, other.length, other.weight, other.whiskerLength);
    }

    /**
     * Method that finds if the Catfish object is shaggy or not (if whisker length is greater than end-to-end length).
     * @return boolean value that determines whether the Catfish is shaggy or not.
     */
    public boolean isShaggy() {
        return whiskerLength > length;
    }

    /**
     * Override toString method that returns string with  name, length, weight, whisker length, determined shagginess.
     * @return String with toString() method from parent class and additional info.
     */
    @Override
    public String toString() {
        return String.format("%s I'm a catfish whose longest whisker is %.2f, so I %s shaggy.",
                super.toString(),
                whiskerLength,
                (isShaggy() ? "am" : "am not"));
    }

    /**
     * Setter method that changes the whisker length to passed argument if it is a valid length.
     * @param whiskerLength Passed argument that the Catfish object's whisker length is changed to if valid.
     */
    public void setWhiskerLength(Double whiskerLength) {
        if (whiskerLength == null || whiskerLength.isNaN() || whiskerLength.isInfinite() || whiskerLength <= 0) {
            this.whiskerLength = 8.0;
        } else {
            this.whiskerLength = whiskerLength;
        }
    }
}
