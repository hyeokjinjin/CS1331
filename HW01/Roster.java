import java.util.Random;

public class Roster {
    private Player[] players;
    private int size;

    public Roster() {
        this(new Player[4]);
    }

    public Roster(Player[] players) {
        this.players = players;
        for (Player pos : players) {
            if (pos != null) {
                size += 1;
            }
        }
    }

    public Player signPlayer(int index, Player player) {
        if (index >= players.length || index < 0 || player == null) {
            System.out.println("Cannot add a player to this spot on the roster.");
            return null;
        } else if (players[index] != null) {
            System.out.println("Replaced: " + players[index]);
            Player oldPlayer = players[index];
            players[index] = player;
            return oldPlayer;
        } else if (players[index] == null) {
            players[index] = player;
            System.out.println("Signed: " + player);
            size++;
            return null;
        }
        return null;
    }

    public Player transferPlayer(int index) {
        if (index >= players.length || index < 0 || players[index] == null) {
            System.out.println("There was no player to transfer!");
            return null;
        }
        Player transferPlayer = players[index];
        players[index] = null;
        System.out.println("Transferred: " + transferPlayer);
        size--;
        return transferPlayer;
    }

    public void showBestPlayers(int skillRatingIn) {
        for (Player player : players) {
            if (player == null) {
                continue;
            } else if (player.getSkillRating() > skillRatingIn) {
                System.out.println(player);
            }
        }
    }

    public void trainAllPlayers() {
        boolean trainable = false;
        for (Player player : players) {
            if (player == null) {
                continue;
            } else if (player.isTrainable()) {
                trainable = true;
            }
        }
        if (trainable) {
            Random rand = new Random();
            for (Player player : players) {
                if (player == null) {
                    continue;
                } else if (player.isTrainable()) {
                    int newSkillRating = (rand.nextInt(10) + 1) + player.getSkillRating();
                    System.out.println("Trained to " + newSkillRating + ": " + player);
                    player.setSkillRating(newSkillRating);
                }
            }
        } else if (!trainable) {
            System.out.println("There were no players to train.");
        }
    }

    public void play(int index, Position position) {
        if (index >= players.length || index < 0 || players[index] == null) {
            System.out.println("Cannot play the player in this spot.");
        } else if (players[index].canPlayAs(position)) {
            Random rand = new Random();
            if (players[index].preferredPosition() == position) {
                players[index].setStamina(players[index].getStamina() - (rand.nextInt(5) + 1));
            } else {
                players[index].setStamina(players[index].getStamina() - (rand.nextInt(6) + 5));
            }
            if (players[index].getStamina() < 0) {
                players[index].setStamina(0);
            }
            System.out.println("Played: " + players[index]);
        } else {
            System.out.println("This player cannot be played in position " + position);
            return;
        }
    }

    public String toString() {
        if (size == 0) {
            return "The Team has no players!";
        }
        String output = "There are " + size + " players on Java FC.\n";
        for (Player player : players) {
            if (player == null) {
                continue;
            }
            output += player + "\n";
        }
        return output.trim();
    }
}