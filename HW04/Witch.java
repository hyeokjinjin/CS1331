/**
 * Class representing the Witch TrickOrTreaters.
 * @author Hyeokjin Jin
 * @version 10/25/23 CS1331
 */
public class Witch extends TrickOrTreater implements Robbable {

    private String signatureCackle;

    /**
     * Witch TrickOrTreater object constructor.
     * @param name String name representing the name of Witch
     * @param age Int age represnting the age of Witch
     * @param numCandy Int representing the number of candy the Witch has
     * @param signatureCackle String representing the Witch's signature cackle
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle == null || signatureCackle.isEmpty() || signatureCackle.isBlank()) {
            this.signatureCackle = "Bwahaha";
        } else {
            this.signatureCackle = signatureCackle;
        }
    }

    /**
     * No argument constructor for Witch object.
     */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    @Override
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!%n", this.signatureCackle);
        this.gainCandy(3);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (super.compareTo(other) == 0 && other instanceof Witch) {
            return Integer.valueOf(this.signatureCackle.length()).compareTo(((Witch) other).signatureCackle.length());
        }
        return super.compareTo(other);
    }

    @Override
    public int beRobbed() {
        int amount;
        if (this.getNumCandy() < 6) {
            amount = this.getNumCandy();
        } else {
            amount = 6;
        }
        this.loseCandy(amount);
        return amount;
    }
}
