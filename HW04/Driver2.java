public class Driver2 {
    public static void main(String[] args) {
        TrickOrTreater[] team1 = new TrickOrTreater[]{new Ghost(), new Witch(), new Witch("May", 18, -1, "Haha"), new Ghost("", 999, 0), new Witch("Evil old lady", -1, 0, "")};
        TrickOrTreater[] team2 = new TrickOrTreater[]{new Ghost(), new Witch(), new Witch("", 1, 0, "Woo"), new Witch(), new Witch()};
        testCase(team1, team2, -1, 1);
        team2[2] = new Ghost("", 0, 99);
        testCase(team1, team2, 100, 2);
        testCase(team1, team2, 101, 3);
        TrickOrTreater[] team3 = team1;
        TrickOrTreater[] team4 = team1;
        testCase(team4, team3, 150, 4);
        System.out.println("\n-------Testing CompareTo method---------------");
        System.out.println(team3[0].compareTo(new Ghost("", 12, 24)));
        System.out.println(team3[3].compareTo(new Ghost("", 8, 39)));
        System.out.println(team3[0].compareTo(new Ghost("", 9, 21)));
        System.out.println(team3[0].compareTo(new Ghost("", 13, 24)));
        System.out.println(team3[0].compareTo(new Witch("", 12, 24, "")));
        System.out.println(team3[0].compareTo(new Witch("", 10, 24, "")));
        System.out.println(team3[1].compareTo(new Witch("", 7, 36, "h")));
        System.out.println(team3[1].compareTo(new Witch("", 8, 36, "")));
    }
    private static void testCase(TrickOrTreater[] team1, TrickOrTreater[] team2, int threshold, int testCaseNum) {
        System.out.printf("\n----------Test Case No.%d-------------\n", testCaseNum);
        HalloweenNight oct31 = new HalloweenNight(team1, team2);
        System.out.println("Before Match " + oct31.toString());
        //printTeam(team1);
        //printTeam(team2);
        oct31.compareTeams();
        oct31.battle(threshold);
        System.out.println("After Match " + oct31.toString());
    }
    private static void printTeam(TrickOrTreater[] input) {
        for (TrickOrTreater a : input) {
            System.out.println(a.toString());
        }
    }
}
