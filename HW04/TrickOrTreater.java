/**
 * Class that functions as a template for trick-or-treaters.
 * @author Hyeokjin Jin
 * @version 10/25/23 CS1331
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {

    private String name;
    private int age;
    private int numCandy;

    /**
     * Constructor for TrickOrTreater object.
     * @param name String representing name of the trick-or-treater
     * @param age Int representing age of the trick-or-treater
     * @param numCandy Int representing the number of candy a trick-or-treater has
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Charlie Brown";
        } else {
            this.name = name;
        }

        if (age < 0 || age > 12) {
            this.age = 8;
        } else {
            this.age = age;
        }

        if (numCandy < 0) {
            this.numCandy = 0;
        } else {
            this.numCandy = numCandy;
        }
    }

    /**
     * Abstract method that specific trick-or-treaters implement.
     */
    public abstract void trickOrTreat();

    /**
     * Method that adds the gained amount of candy to the trick-or-treater's total number of candy.
     * @param amount Int amount that is added to total number of candy
     */
    protected void gainCandy(int amount) {
        if (amount > 0) {
            numCandy += amount;
        }
    }

    /**
     * Method that subtracts specified amount of candy from a trick-or-treater's candy basket.
     * @param lostCandy Specified integer amount of candy that is lost
     * @return Integer amount of candy that was deducted
     */
    protected int loseCandy(int lostCandy) {
        if (lostCandy > 0) {
            if (lostCandy > this.numCandy) {
                lostCandy = this.numCandy;
            }
            this.numCandy -= lostCandy;
        }
        return lostCandy;
    }

    @Override
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy == other.numCandy) {
            return Integer.valueOf(this.age).compareTo(other.age);
        } else {
            return Integer.valueOf(this.numCandy).compareTo(other.numCandy);
        }
    }

    /**
     * Getter method for numCandy.
     * @return numCandy
     */
    public int getNumCandy() {
        return this.numCandy;
    }
}