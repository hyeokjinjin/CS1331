/**
 * StripedBass class that extends the Fish class.
 * @author Hyeokjin Jin
 * @version HW02 10/11/23
 */
public class StripedBass extends Fish {
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * StrippedBass constructor that takes in name, length, weight, stripeCount, isSaltwater, and BestFriend.
     * @param name Name of StripedBass.
     * @param length Length of StripedBass.
     * @param weight Weight of StripedBass.
     * @param stripeCount Number of stripes of the StripedBass.
     * @param isSaltwater Boolean value that determines whether StripedBass is a saltwater or freshwater fish.
     * @param bestFriend Catfish object that is the StripedBass's best friend if one exists.
     */
    public StripedBass(
            String name, Double length, Double weight, int stripeCount, boolean isSaltwater, Catfish bestFriend) {
        super(name, length, weight);
        if (stripeCount > 0) {
            this.stripeCount = stripeCount;
        } else {
            this.stripeCount = 25;
        }
        this.isSaltwater = isSaltwater;
        if (bestFriend != null) {
            this.bestFriend = new Catfish(bestFriend);
        } else {
            this.bestFriend = null;
        }
    }

    /**
     * StripedBass constructor without any parameters and defaults to set values.
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /**
     * Deep copy constructor for the StripedBass object.
     * @param other Different StripedBass object that is deep copied.
     */
    public StripedBass(StripedBass other) {
        this(other.name, other.length, other.weight, other.stripeCount, other.isSaltwater, other.bestFriend);
    }

    /**
     * Method that changes the StripedBass's location if the object does not have a best friend.
     */
    public void migrate() {
        if (bestFriend == null) {
            isSaltwater = !isSaltwater;
        }
    }

    /**
     * Override toString method that adds information about the StripedBass object in addition to the parent toString.
     * @return String containing name, length, weight, type of water, number of stripes,
     * and whether the StripedBass object has a Catfish best friend.
     */
    @Override
    public String toString() {
        return String.format("%s I'm a %s striped bass with %d stripes. I have %s.",
                super.toString(), (isSaltwater ? "saltwater" : "freshwater"),
                stripeCount,
                (bestFriend == null) ? "no best friend" : String.format("a best friend named %s", bestFriend.name));
    }
}
