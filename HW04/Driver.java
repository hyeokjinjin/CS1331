public class Driver {
    public static void main(String[] args) {
        Ghost ghost1 = new Ghost("Ghost1", 0, 0);
        Ghost ghost2 = new Ghost("Ghost2", 0, 0);
        Ghost ghost3 = new Ghost("Ghost3", 0, 0);
        Ghost ghost4 = new Ghost("Ghost4", 0, 0);
        Ghost ghost5 = new Ghost("Ghost5", 0, 0);
        Witch witch1 = new Witch("Witch1", 0, 0, "Witch1");
        Witch witch2 = new Witch("Witch2", 0, 0, "Witch2");
        Witch witch3 = new Witch("Witch3", 0, 0, "Witch3");
        Witch witch4 = new Witch("Witch4", 0, 0, "Witch4");
        Witch witch5 = new Witch("Witch5", 0, 0, "Witch5");

        witch1.trickOrTreat();
        System.out.println("Witch 1 Candies: " + witch1.getNumCandy());
        System.out.println("Ghost 1 Candies: " + ghost1.getNumCandy());

        ghost1.rob(witch1);

        System.out.println("Witch 1 Candies: " + witch1.getNumCandy());
        System.out.println("Ghost 1 Candies: " + ghost1.getNumCandy());

        System.out.println(ghost1);
        System.out.println(witch1);

        System.out.println(witch1.compareTo(ghost1));

        TrickOrTreater[] test1 = new TrickOrTreater[]{ghost1, ghost2, ghost3, ghost4, ghost5};
        TrickOrTreater[] test2 = new TrickOrTreater[]{witch1, witch2, witch3, witch4, witch5};

        HalloweenNight driver = new HalloweenNight(test1, test2);
        System.out.println(driver);
        driver.compareTeams();

        driver.battle(80);


    }
}
