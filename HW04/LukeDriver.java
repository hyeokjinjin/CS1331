public class LukeDriver {
    public static void main(String[] args) {
    
    //Test constructors and toString()
    Ghost g1 = new Ghost("Ghastly", 10, 5);
    Ghost g2 = new Ghost();
    System.out.println(g1);
    System.out.println(g2);

    Witch w1 = new Witch("Witchy", 8, 3, "Hoohah");
    Witch w2 = new Witch();
    System.out.println(w1);
    System.out.println(w2);

    Ghost nameNull = new Ghost(null, -1, -1);//name null, candy below 0, age below 0
    System.out.printf("Name should be Charlie Brown, age should be 8, candy - 0: %s\n", nameNull);
    Ghost emptyName = new Ghost("", 15, 15);//name empty, age above 12
    System.out.printf("Name should be Charlie Brown, age should be 8: %s\n", emptyName);//name blank
    Ghost blankName = new Ghost("      ", 10, 10);
    System.out.printf("Ghost name should be Charlie Brown: %s\n\n", blankName);

    Witch nullCackle = new Witch("nullCackle", 10, 10, null);
    System.out.printf("Witch cackle should be Bwahaha: ");
    nullCackle.trickOrTreat();
    Witch emptyCackle = new Witch("emptyCackle", 10, 10, "");
    System.out.printf("Witch cackle should be Bwahaha: ");
    emptyCackle.trickOrTreat();
    Witch blankCackle = new Witch("blankCackle", 10, 10, "     ");
    System.out.printf("Witch cackle should be Bwahaha: ");
    blankCackle.trickOrTreat();
    System.out.println("\n");

    //Test ghost
    System.out.printf("Ghost g1 has %d pieces of candy!\n", g1.getNumCandy());
    g1.trickOrTreat();
    System.out.printf("Should be two more now! G1 has %d candy!\n", g1.getNumCandy());

    //instantiate robbables
    Witch t = new Witch("WitchT", 10, 7, "Hehe");
    Witch w = new Witch();
    Witch ww = new Witch("Witch-kindaBroke", 10, 3, "Hehe");
    Ghost g = new Ghost("Ghost", 10, 5);
    
    //Test robbables
    g1.rob(t);
    System.out.printf("G1 should have 1 robbery now and gained 6 candy: %s\n", g1);
    System.out.printf("WitchT should have 1 candy now: %s\n\n", t);

    g1.rob(w);
    System.out.printf("G1 should have 1 robbery still and gained 0 candy: %s\n", g1);
    System.out.printf("Maleficent should have 0 candy still: %s\n\n", w);
    
    System.out.printf("Witch should have 3 candy now: %s\n", ww);
    g1.rob(ww);
    System.out.printf("G1 should have 2 robberies now and gained 3 candy: %s\n", g1);
    System.out.printf("Witch should have 0 candy now: %s\n\n", ww);

    System.out.printf("Ghost should have 5 candy now: %s\n", g);
    g1.rob(g);
    System.out.printf("G1 should have same candy now and same robberies: %s\n", g1);
    System.out.printf("Ghost should have 5 candy still: %s\n\n", g);

    //Ghost compareTo test
    Ghost brokeGhost1 = new Ghost();
    Ghost brokeGhost2 = new Ghost();
    Witch sameAge = new Witch("sameAge", 12, 0, "hi");
    Witch older = new Witch("older", 11, 10, "hi");
    Witch younger = new Witch("younger", 3, 0, "hi");
    Ghost richGhost1 = new Ghost("Ballin", 10, 10);
    Ghost lessRobberies = new Ghost("LessRobs", 8, 16);

    System.out.printf("Should be 0: %d\n", brokeGhost1.compareTo(sameAge));
    System.out.printf("Should be negative: %d\n", richGhost1.compareTo(older));
    System.out.printf("Should be positive: %d\n", brokeGhost1.compareTo(younger));
    System.out.printf("Should be negative: %d\n", brokeGhost1.compareTo(richGhost1));
    System.out.printf("Should be positive: %d\n", richGhost1.compareTo(brokeGhost2));
    System.out.printf("Should be 0: %d\n", brokeGhost1.compareTo(brokeGhost2));
    System.out.printf("Should be negative: %d\n", lessRobberies.compareTo(g1));
    System.out.printf("Should be positive: %d\n", g1.compareTo(lessRobberies));
    System.out.printf("Should be 0: %d\n\n\n", g1.compareTo(g1));

    //Witch testing
    System.out.printf("Testing Witch ------------------------------\n");
    Witch w3 = new Witch("Witchy2", 8, 3, "Hoohah");
    Witch w4 = new Witch();
    Witch w5 = new Witch();
    Witch longCackle = new Witch("WitchyLong", 8, 6, "Thisisalongcackle");
    Witch longCackle2 = new Witch("WitchyLong", 8, 6, "Thisisalongcackll");
    Ghost brokeGhost3 = new Ghost("brokey", 7, 0);
    Ghost brokeGhost4 = new Ghost("brokey", 9, 0);
    Ghost brokeGhost5 = new Ghost("brokey", 6, 0);
    //Testing trickOrTreat()
    System.out.println(w3);
    w3.trickOrTreat();
    System.out.printf("Should have gained 3 pieces of candy: %s\n\n", w3);

    //Testing compareTo
    System.out.printf("Should be 0: %d\n", w4.compareTo(brokeGhost3));
    System.out.printf("Should be negative: %d\n", w4.compareTo(brokeGhost4)); //same candy, less age
    System.out.printf("Should be positive: %d\n", w4.compareTo(brokeGhost5)); //same candy, more age
    System.out.printf("Should be negative: %d\n", w4.compareTo(w3));
    System.out.printf("Should be positive: %d\n", w3.compareTo(w4));
    System.out.printf("Should be 0: %d\n", w4.compareTo(w5));
    System.out.printf("Should be negative: %d\n", w3.compareTo(longCackle));
    System.out.printf("Should be positive: %d\n", longCackle.compareTo(w3));
    System.out.printf("Should be 0: %d\n\n\n", longCackle.compareTo(longCackle2));

    //Test HalloweenNight
    System.out.print("Testing HalloweenNight -------------\n\n");
    Ghost ckf0 = new Ghost();
    Ghost ckf3 = new Ghost();
    Ghost ckf4 = new Ghost();
    Ghost gg0 = new Ghost();
    Witch ckf2 = new Witch();
    Witch ckf1 = new Witch();
    Witch gg1 = new Witch();
    Witch gg4 = new Witch();
    Witch gg3 = new Witch();
    Ghost gg2 = new Ghost();

    TrickOrTreater[] ckf = new TrickOrTreater[]{ckf0, ckf1, ckf2, ckf3, ckf4};
    TrickOrTreater[] gg = new TrickOrTreater[]{gg0, gg1, gg2, gg3, gg4};
    // TrickOrTreater[] ggg = new TrickOrTreater[]{ckf0, ckf1, ckf2, ckf3, ckf4};
    // TrickOrTreater[] ckfc = new TrickOrTreater[]{gg0, gg1, gg2, gg3, gg4};


    HalloweenNight hn = new HalloweenNight(ckf, gg);
    System.out.println(hn + "\n\n");
    HalloweenNight hn2 = new HalloweenNight(gg, ckf);
    HalloweenNight hn3 = new HalloweenNight(gg, gg);

    System.out.print("Should be ckf favored: ");
    hn.compareTeams();
    System.out.println();

    System.out.print("Should be gg favored: ");
    hn2.compareTeams();
    System.out.println();

    System.out.print("Should be neither favored: ");
    hn3.compareTeams();
    System.out.println();

    //Battle
    hn.battle(90);
    System.out.println("\n");
    System.out.println("Should default to 60 points:");
    hn.battle(-1);
    }
}
