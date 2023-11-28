public class Driver3 {
    public static void main(String[] args) {
        int testCase = 5; // Change to test different teams. Valid from 1 to 4

        System.out.println("-----Create Ghosts-----");
        TrickOrTreater ghost1 = new Ghost("Alice", 5, 10);
        System.out.println(ghost1);
        TrickOrTreater ghost2 = new Ghost("Bob", 10, 5);
        System.out.println(ghost2);
        TrickOrTreater ghost3 = new Ghost("Carol", 10, 5);
        System.out.println(ghost3);
        TrickOrTreater ghost4 = new Ghost("David", 12, 3);
        System.out.println(ghost4);
        TrickOrTreater ghost5 = new Ghost("Eve", 7, 8);
        System.out.println(ghost5);
        TrickOrTreater ghost6 = new Ghost();
        System.out.println(ghost6);
        TrickOrTreater ghost7 = new Ghost(null, 50, -50);
        System.out.println(ghost7);
        TrickOrTreater dupGhost = new Ghost("Bob", 10, 5);

        System.out.println("\n-----Create Witches-----");
        TrickOrTreater witch1 = new Witch("Frank", 8, 12, "Hahaha");
        System.out.println(witch1);
        TrickOrTreater witch2 = new Witch("Grace", 6, 7, "Muahaha");
        System.out.println(witch2);
        TrickOrTreater witch3 = new Witch("Henry", 5, 3, "Ahahaha");
        System.out.println(witch3);
        TrickOrTreater witch4 = new Witch("Iris", 6, 7, "Cackle");
        System.out.println(witch4);
        TrickOrTreater witch5 = new Witch("Jack", 10, 0, "Teeheehee");
        System.out.println(witch5);
        TrickOrTreater witch6 = new Witch();
        System.out.println(witch6);
        TrickOrTreater witch7 = new Witch("    ", -50, -50, "");
        System.out.println(witch7);
        TrickOrTreater dupWitch = new Witch("Grace", 6, 7, "Muahaha");

        System.out.println("\n-----Test compareTo-----");
        System.out.println(ghost2.compareTo(ghost1));
        System.out.println(ghost2.compareTo(ghost4));
        System.out.println(ghost2.compareTo(ghost3));
        System.out.println(ghost2.compareTo(dupGhost));
        System.out.println();
        System.out.println(witch2.compareTo(witch1));
        System.out.println(witch2.compareTo(witch3));
        System.out.println(witch2.compareTo(witch4));
        System.out.println(witch2.compareTo(dupWitch));

        System.out.println("\n-----Test gainCandy and loseCandy edge cases-----");
        System.out.println(dupGhost);
        dupGhost.gainCandy(-5);
        System.out.println(dupGhost);
        System.out.println(dupGhost.loseCandy(10));
        System.out.println(dupGhost);

        TrickOrTreater[] team1;
        TrickOrTreater[] team2;
        HalloweenNight night;

        switch (testCase) {
            case 1:
                System.out.println("\n-----Halloween Night 1!-----");
                team1 = new TrickOrTreater[]{ghost1, ghost3, witch4, ghost2, witch5};
                team2 = new TrickOrTreater[]{witch3, ghost4, witch2, witch1, ghost5};
                night = new HalloweenNight(team1, team2);
                System.out.println(night);
                night.compareTeams();
                night.battle(60);
                System.out.println(night);
                break;
            case 2:
                System.out.println("\n-----Halloween Night 2!-----");
                team1 = new TrickOrTreater[]{witch1, witch2, ghost7, ghost4, witch5};
                team2 = new TrickOrTreater[]{ghost3, ghost6, ghost2, witch3, witch2};
                night = new HalloweenNight(team1, team2);
                System.out.println(night);
                night.compareTeams();
                night.battle(-10);
                System.out.println(night);
                break;
            case 3:
                System.out.println("\n-----Halloween Night 3!-----");
                team1 = new TrickOrTreater[]{ghost1, witch3, ghost3, witch7, witch2};
                team2 = new TrickOrTreater[]{witch2, ghost2, witch5, ghost4, dupWitch};
                night = new HalloweenNight(team1, team2);
                System.out.println(night);
                night.compareTeams();
                night.battle(100);
                System.out.println(night);
                break;
            case 4:
                System.out.println("\n-----Halloween Night 4!-----");
                team1 = new TrickOrTreater[]{ghost1, witch2, ghost3, witch4, ghost5};
                team2 = new TrickOrTreater[]{witch1, ghost2, witch3, ghost4, witch5};
                night = new HalloweenNight(team1, team2);
                System.out.println(night);
                night.compareTeams();
                night.battle(60);
                System.out.println(night);
                break;
            case 5:
                System.out.println("\n-----Halloween Night 5!-----");
                team1 = new TrickOrTreater[]{ghost1, witch1, ghost2, witch2, ghost3};
                team2 = new TrickOrTreater[]{witch2, ghost2, witch3, ghost4, witch5};
                night = new HalloweenNight(team1, team2);
                System.out.println(night);
                night.compareTeams();
                night.battle(10);
                System.out.println(night);
                break;
            default:
                System.out.println("\nPlease enter a valid case from 1-4!");
        }
    }
}
