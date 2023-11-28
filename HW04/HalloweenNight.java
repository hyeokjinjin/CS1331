/**
 * Method representing the events occurring between two teams on Halloween Night.
 * @author Hyeokjin Jin
 * @version 10/25/23 CS1331
 */
public class HalloweenNight {

    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;

    /**
     * HalloweenNight object constructor.
     * @param cryptKickerFive Inputted array representing the roster for cryptKickerFive team
     * @param ghoulGang Inputted array representing the roster for ghoulGang team
     */
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
    }

    @Override
    public String toString() {
        String cKF = "cryptKickerFive: ";
        String gG = "ghoulGang: ";
        for (int i = 0; i < 5; i++) {
            cKF += cryptKickerFive[i];
            gG += ghoulGang[i];
            if (i < 4) {
                cKF += ", ";
                gG += ", ";
            }
        }
        return String.format("%s versus %s", cKF, gG);
    }

    /**
     * Method that compares both teams and finds which team is at an advantage, if any.
     */
    public void compareTeams() {
        int points = 0;
        for (int i = 0; i < 5; i++) {
            points += cryptKickerFive[i].compareTo(ghoulGang[i]);
        }
        if (points > 0) {
            System.out.println("cryptKickerFive is favored.");
        } else if (points < 0) {
            System.out.println("ghoulGang is favored.");
        } else {
            System.out.println("Neither team is favored.");
        }
    }

    /**
     * Method that puts both teams in a battle to see who earns the inputting amount of candy first.
     * @param threshold Integer representing the needed amount of candy for a team to win
     */
    public void battle(int threshold) {
        if (threshold <= 0) {
            threshold = 60;
        }

        int cryptCandyTotal;
        int ghoulCandyTotal;

        do {
            cryptCandyTotal = 0;
            ghoulCandyTotal = 0;

            for (int i = 0; i < cryptKickerFive.length; i++) {
                cryptKickerFive[i].trickOrTreat();
                if (cryptKickerFive[i] instanceof Ghost) {
                    if (ghoulGang[i] instanceof Robbable) {
                        ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
                    }
                }
            }

            for (int i = 0; i < ghoulGang.length; i++) {
                ghoulGang[i].trickOrTreat();
                if (ghoulGang[i] instanceof Ghost) {
                    if (cryptKickerFive[i] instanceof Robbable) {
                        ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
                    }
                }
            }

            for (TrickOrTreater cKF : cryptKickerFive) {
                cryptCandyTotal += cKF.getNumCandy();
            }
            for (TrickOrTreater gG : ghoulGang) {
                ghoulCandyTotal += gG.getNumCandy();
            }
        }
        while (cryptCandyTotal < threshold && ghoulCandyTotal < threshold);

        if (cryptCandyTotal >= threshold && ghoulCandyTotal >= threshold) {
            System.out.println("It is a tie!");
        } else if (cryptCandyTotal >= threshold) {
            System.out.println("cryptKickerFive won!");
        } else {
            System.out.println("ghoulGang won!");
        }
    }
}

