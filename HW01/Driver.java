public class Driver {
    public static void main(String[] args) {
        Roster roster = new Roster(new Player[3]);
        Player messi = new Player();
        Player ronaldo = new Player("Cristiano Ronaldo", new Position[]{Position.MIDFIELDER, Position.MIDFIELDER});
        Player son = new Player("Son Heung-Min", 85, new Position[]{Position.DEFENDER, Position.GOALKEEPER}, 70);
        Player player = new Player("Player", 101, new Position[]{}, 101);

        System.out.println(player.preferredPosition());
        System.out.println(player);
        System.out.println();

        roster.signPlayer(0, messi);
        System.out.println(roster);
        System.out.println();

        roster.signPlayer(1, ronaldo);
        System.out.println(roster);
        System.out.println();

        roster.signPlayer(2, son);
        System.out.println(roster);
        System.out.println();

        roster.transferPlayer(1);
        System.out.println(roster);
        System.out.println();

        roster.showBestPlayers(70);
        System.out.println();

        roster.trainAllPlayers();
        System.out.println(roster);
        System.out.println();

        roster.play(0, Position.FORWARD);
        System.out.println(roster);
        System.out.println();

        roster.play(2, Position.GOALKEEPER);
        System.out.println(roster);
        System.out.println();

        roster.play(1, Position.GOALKEEPER);
        System.out.println();

        roster.play(2, Position.MIDFIELDER);
        System.out.println();

    }
}