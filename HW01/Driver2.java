public class Driver2 {
    public static void main(String[] args) {
        Roster r1 = new Roster();
        Player p1 = new Player();
        Player p2 = new Player("Joe Shmoe",
                new Position[] {Position.GOALKEEPER, Position.DEFENDER});
        Player p3 = new Player("Cristiano Ronaldo", 80,
                new Position[] {Position.FORWARD, Position.MIDFIELDER}, 81);

        Player newP1 = new Player();
        Player newP2 = new Player("Joe Shmoe",
                new Position[] {Position.GOALKEEPER, Position.DEFENDER});
        Player newP3 = new Player("Cristiano Ronaldo", 80,
                new Position[] {Position.FORWARD, Position.MIDFIELDER}, 81);
        Roster r2 = new Roster(new Player[] {newP1, newP2, newP3});
        Player newP4 = new Player("John Deere",
                new Position[] {Position.MIDFIELDER, Position.GOALKEEPER});
        Roster nullRoster = new Roster();
        Player nullPlayer = null;

        // MAKE SURE TO TEST IF ALL OF THE SETTERS AND GETTERS ARE *NECCESSARY*
        /* Player tests */
        // Test player constructors and player toString()
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println();

        // Test player methods methods
        // isTrainable()
        System.out.println(p1.isTrainable() + " -- should be false");
        System.out.println(p2.isTrainable() + " -- should be true");
        System.out.println();

        // preferredPosition() //may require further testing based on passed conditions
        System.out.println(p3.preferredPosition() + " -- should be FORWARD");
        System.out.println();

        // canPlayAs()
        System.out.println(p2.canPlayAs(Position.GOALKEEPER) + " -- should be true");
        System.out.println(p2.canPlayAs(Position.DEFENDER) + " -- should be true");
        System.out.println(p2.canPlayAs(Position.FORWARD) + " -- should be false");
        System.out.println();

        /* Roster Tests */
        // Test roster constructors and roster toString()
        System.out.println(r1 + " -- should have no players");
        System.out.println(r2 + " -- should print 3 players");
        System.out.println();

        // signPlayer()
        Player oldPlayer1 = r1.signPlayer(0, p1);
        System.out.println(oldPlayer1 != null ? oldPlayer1 + " -- should NOT print player\n"
                : " -- The old player is null and should be.\n");
        Player oldPlayer2 = r1.signPlayer(2, p2);
        System.out.println(oldPlayer2 != null ? oldPlayer2 + " -- should NOT print player\n"
                : " -- The old player is null and should be.\n");
        Player oldPlayer3 = r1.signPlayer(3, p3);
        System.out.println(oldPlayer3 != null ? oldPlayer3 + " -- should NOT print player\n"
                : " -- The old player is null and should be.\n");
        Player oldPlayer4 = r2.signPlayer(0, newP4);
        System.out.println(oldPlayer4 != null ? oldPlayer4 + " -- should print a player\n"
                : " -- The old player is null and should NOT be.\n");
        System.out.println(r1.signPlayer(0, nullPlayer) + " -- should print error message and return null\n");
        System.out.println(r1.signPlayer(-1, p1) + " -- should print error message and return null\n");
        System.out.println(r1.signPlayer(200, p1) + " --should print error message and return null\n");
        System.out.println(r1.signPlayer(4, p1) + " --should print error message and return null\n");
        System.out.println();

        // transferPlayer()
        System.out.println("These following transfers should all have an accompanying transfer statement:\n");
        Player transfer1 = r1.transferPlayer(0);
        System.out.println(transfer1 != null ? transfer1 + " -- should print a player\n"
                : "The player is null and should NOT be\n");
        Player transfer2 = nullRoster.transferPlayer(0);
        System.out.println(transfer2 != null ? transfer2 + " -- should NOT print a player\n"
                : " -- Should print error statement\n");
        Player transfer3 = r1.transferPlayer(-1);
        System.out.println(transfer3 != null ? transfer3 + " -- should NOT print a player\n"
                : " -- Should print error statement\n");
        Player transfer4 = r2.transferPlayer(3);
        System.out.println(transfer3 != null ? transfer3 + " -- should NOT print a player\n"
                : " -- Should print error statement\n");

        // showBestPlayers()
        System.out.println("The roster r2 is:\n " + r2 + " -- pay attention to the players with ratings above 80");
        System.out.println("This should show all of the players with skill rating ABOVE 80:");
        r2.showBestPlayers(80);
        System.out.println();
        System.out.println("Should print all 3 players:");
        r2.showBestPlayers(79);
        System.out.println();

        System.out.println("Should print nothing: ");
        nullRoster.showBestPlayers(80);
        System.out.println();
        Player oldPlayer5 = nullRoster.signPlayer(0, p3);
        System.out.println("Should print 1 player:");
        nullRoster.showBestPlayers(0);
        nullRoster.transferPlayer(0);
        System.out.println();

        // trainAllPlayers()
        r2.trainAllPlayers();
        System.out.println();
        System.out.println("The changes should be reflected here:");
        System.out.println(r2);

        System.out.println("Should print that there's no players to train");
        nullRoster.trainAllPlayers();
        System.out.println();
        nullRoster.signPlayer(2, p1);
        System.out.println("Should print that there's no players to train");
        nullRoster.trainAllPlayers();
        System.out.println();

        System.out.println("Making sure, players don't train above limit");
        for (int i = 0; i < 10; i++) {
            r2.trainAllPlayers();
        }
        System.out.println();

        // play()
//        System.out.println("Should subtract 1-5 stamina:");
//        System.out.println(r1.getPlayers()[2]);
//        r1.play(2, Position.GOALKEEPER);
//        System.out.println("Should subtract 5-10 stamina:");
//        System.out.println(r1.getPlayers()[2]);
//        r1.play(2, Position.DEFENDER);
//        System.out.println("Should print an error message:");
//        System.out.println(r1.getPlayers()[2]);
//        r1.play(2, Position.FORWARD);
//        System.out.println();
//        System.out.println("We will now run the stamina down to 0, should not go below");
//        for (int i = 0; i < 25; i++) {
//            r1.play(2, Position.DEFENDER);
//        }

    }
}
