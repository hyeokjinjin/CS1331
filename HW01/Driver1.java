/**
 * ATTENTION!, because PLAY() subtracts a random integer, your players' stamina will be different from mine
 * Driver for HW1, separated into 2 sections, section 1 based on HW1 instructions
 * Section 2 is me trying to break the program
 * @author yiyangyu
 * @version 0.1
 */

public class Driver1 {
   public static void main(String[] args) {
      System.out.println("---------------------------");
      //First section testing based on HW1 instructions
      Roster firstRoster = new Roster(new Player[3]);
      Player bob = new Player("Bob", new Position[]{Position.GOALKEEPER, Position.DEFENDER});
      Player messi = new Player();
      Player jimmy = new Player("Jimmy", 10, new Position[]{Position.MIDFIELDER}, 10);
      firstRoster.signPlayer(0,bob);
      firstRoster.signPlayer(1,messi);
      firstRoster.signPlayer(2,jimmy);
   
      System.out.println(firstRoster.transferPlayer(2));
      System.out.println(firstRoster);
   
      firstRoster.showBestPlayers(20);
      firstRoster.trainAllPlayers();
   
      System.out.println(firstRoster);
   
      firstRoster.play(0, Position.GOALKEEPER);
      firstRoster.play(1, Position.MIDFIELDER);
      firstRoster.play(2, Position.FORWARD);
      /* OUTPUT
      ---------------------------
      Skill rating: Great
      Signed: <Bob,75,GOALKEEPER,80,true>
      Signed: <Lionel Messi,75,FORWARD,100,false>
      Signed: <Jimmy,10,MIDFIELDER,80,true>
      Transferred: <Jimmy,10,MIDFIELDER,80,true>
      <Jimmy,10,MIDFIELDER,80,true>
      There are 2 players on Java FC.
      <Bob,75,GOALKEEPER,80,true>
      <Lionel Messi,75,FORWARD,100,false>
      <Bob,75,GOALKEEPER,80,true>
      <Lionel Messi,75,FORWARD,100,false>
      Trained to 88 : <Bob,75,GOALKEEPER,80,true>
      There are 2 players on Java FC.
      <Bob,75,GOALKEEPER,88,true>
      <Lionel Messi,75,FORWARD,100,false>
      Played: <Bob,74,GOALKEEPER,88,true>
      This player cannot be played in position
      Cannot play the player in this spot.
       */
      System.out.println("\n\n\n------------------------------------");
   
   
   
      //Second section testing - more extreme cases
      Roster secondRoster = new Roster(new Player[5]);
      secondRoster.signPlayer(1, new Player("bruh", 2000, new Position[]{}, 2000));
      System.out.println(secondRoster);
      System.out.println(secondRoster.transferPlayer(1));
      secondRoster.signPlayer(1, new Player("lol", -13004, new Position[]{null, null, null, null}, -6900));
      System.out.println(secondRoster.transferPlayer(10));
      secondRoster.trainAllPlayers();
      secondRoster.play(1, Position.FORWARD);
      System.out.println(secondRoster);
      secondRoster.showBestPlayers(0);
      System.out.println("-----------------------------------\n\n\n");
      /*OUTPUT
      ------------------------------------
      Skill rating: Great
      Signed: <bruh,75,MIDFIELDER,80,true>
      There are 1 players on Java FC.
      <bruh,75,MIDFIELDER,80,true>
      Transferred: <bruh,75,MIDFIELDER,80,true>
      <bruh,75,MIDFIELDER,80,true>
      Skill rating: Great
      Signed: <lol,75,MIDFIELDER,80,true>
      There was no player to transfer!
      null
      Trained to 80 : <lol,75,MIDFIELDER,80,true>
      This player cannot be played in position
      There are 1 players on Java FC.
      <lol,75,MIDFIELDER,80,true>
      <lol,75,MIDFIELDER,80,true>
      -----------------------------------
       */
   
   
   
   
   }
}
