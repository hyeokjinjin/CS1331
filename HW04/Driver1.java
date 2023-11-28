import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Driver to test the code.
 *
 * @author David Andrews
 * @version 1.0
 */
public class Driver1 {
    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        TrickOrTreater[] team1 = makeTeam1();
        TrickOrTreater[] team2 = makeTeam2();

        testHalloweenNight(team1, team2);
    }

    private static TrickOrTreater[] makeTeam1() {
        // make a team of: 3 ghosts, 2 witches

        Ghost ghost1 = new Ghost();
        assert ghost1.toString()
                .equals("Casper the Unfriendly Ghost/12/0/0") : "Ghost.toString() is incorrect: "
                        + ghost1.toString();

        Witch witch2 = new Witch();
        assert witch2.toString().equals("Maleficent/7/0") : "Witch.toString() is incorrect: "
                + witch2.toString();

        Ghost ghost3 = new Ghost("ghost3", 14, 0);
        assert ghost3.toString().equals("ghost3/8/0/0") : "Ghost.toString() is incorrect: "
                + ghost3.toString();

        Witch witch4 = new Witch("witch4", 4, 0, "cackle4");
        assert witch4.toString().equals("witch4/4/0") : "Witch.toString() is incorrect: "
                + witch4.toString();

        Ghost ghost5 = new Ghost(null, 10, -1);
        assert ghost5.toString().equals("Charlie Brown/10/0/0") : "Ghost.toString() is incorrect: "
                + ghost5.toString();

        return new TrickOrTreater[] {ghost1, witch2, ghost3, witch4, ghost5};
    }

    private static TrickOrTreater[] makeTeam2() {
        // make team of: 3 witches, 2 ghosts

        Witch witch1 = new Witch("witch1", 12, 0, "cackle1");
        assert witch1.toString().equals("witch1/12/0") : "Witch.toString() is incorrect: "
                + witch1.toString();

        Witch witch2 = new Witch("witch2", 4, 0, "cackle2");
        assert witch2.toString().equals("witch2/4/0") : "Witch.toString() is incorrect: "
                + witch2.toString();

        Ghost ghost3 = new Ghost("ghost3", 10, 0);
        assert ghost3.toString().equals("ghost3/10/0/0") : "Ghost.toString() is incorrect: "
                + ghost3.toString();

        Ghost ghost4 = new Ghost(" ", 1, 0);
        assert ghost4.toString().equals("Charlie Brown/1/0/0") : "Ghost.toString() is incorrect: "
                + ghost4.toString();

        Ghost ghost5 = new Ghost("ghost5", -1, 3);
        assert ghost5.toString().equals("ghost5/8/3/0") : "Ghost.toString() is incorrect: "
                + ghost5.toString();

        return new TrickOrTreater[] {witch1, witch2, ghost3, ghost4, ghost5};
    }

    private static void testHalloweenNight(TrickOrTreater[] team1, TrickOrTreater[] team2) {
        // test ghost vs ghost, witch vs witch, and ghost vs witch

        HalloweenNight hw = new HalloweenNight(team1, team2);
        assert hw.toString().equals("cryptKickerFive: "
                + "Casper the Unfriendly Ghost/12/0/0, Maleficent/7/0, ghost3/8/0/0, witch4/4/0, Charlie Brown/10/0/0"
                + " versus ghoulGang: " + "witch1/12/0, witch2/4/0, ghost3/10/0/0,"
                + " Charlie Brown/1/0/0, ghost5/8/3/0") : "HalloweenNight.toString() is incorrect: "
                        + hw.toString();

        String comparisonOutcome = captureConsole(hw::compareTeams);

        assert comparisonOutcome.equals(
                "Neither team is favored.\n") : "HalloweenNight.compareTeams() is incorrect: "
                        + comparisonOutcome;

        String battleOutcome = captureConsole(() -> hw.battle(20));

        assert battleOutcome.equals("Boo! Trick or treat!\n" + "Bwahaha! I'll get you my pretty!\n"
                + "Boo! Trick or treat!\n" + "cackle4! I'll get you my pretty!\n"
                + "Boo! Trick or treat!\n" + "cackle1! I'll get you my pretty!\n"
                + "cackle2! I'll get you my pretty!\n" + "Boo! Trick or treat!\n"
                + "Boo! Trick or treat!\n" + "Boo! Trick or treat!\n" + "Boo! Trick or treat!\n"
                + "Bwahaha! I'll get you my pretty!\n" + "Boo! Trick or treat!\n"
                + "cackle4! I'll get you my pretty!\n" + "Boo! Trick or treat!\n"
                + "cackle1! I'll get you my pretty!\n" + "cackle2! I'll get you my pretty!\n"
                + "Boo! Trick or treat!\n" + "Boo! Trick or treat!\n" + "Boo! Trick or treat!\n"
                + "It is a tie!\n") : "HalloweenNight.battle() is incorrect: " + battleOutcome;

        assert hw.toString().equals("cryptKickerFive: "
                + "Casper the Unfriendly Ghost/12/7/1, Maleficent/7/6, ghost3/8/4/0, witch4/4/0, Charlie Brown/10/4/0"
                + " versus ghoulGang: " + "witch1/12/3, witch2/4/6, ghost3/10/4/0, "
                + "Charlie Brown/1/10/2, ghost5/8/7/0") : "HalloweenNight.toString() is incorrect: "
                        + hw.toString();
    }

    private static String captureConsole(Runnable r) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        r.run();

        System.setOut(originalOut);

        return out.toString();
    }
}
