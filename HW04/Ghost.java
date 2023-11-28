/**
 * Class representing the Ghost TrickOrTreaters.
 * @author Hyeokjin Jin
 * @version 10/25/23 CS1331
 */
public class Ghost extends TrickOrTreater {

    private int robberiesConducted;

    /**
     * Ghost TrickOrTreater object constructor.
     * @param name String name representing the name of Ghost
     * @param age Int age represnting the age of Ghost
     * @param numCandy Int representing the number of candy the Ghost has
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /**
     * No argument constructor for Ghost object.
     */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    @Override
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        this.gainCandy(2);
    }

    /**
     * Method that robs a robbable trick-or-treater and gains stolen candy.
     * @param victim TrickOrTreater object that is robbed, if possible
     */
    public void rob(TrickOrTreater victim) {
        if (victim instanceof Robbable && (victim.getNumCandy() > 0)) {
            int robbedCandies = ((Robbable) victim).beRobbed();
            this.gainCandy(robbedCandies);
            this.robberiesConducted++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s/%d", super.toString(), this.robberiesConducted);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (super.compareTo(other) == 0 && other instanceof Ghost) {
            return Integer.valueOf(this.robberiesConducted).compareTo(((Ghost) other).robberiesConducted);
        }
        return super.compareTo(other);
    }
}

