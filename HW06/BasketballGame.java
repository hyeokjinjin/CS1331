/**
 * Subclass of SportGame that describes a basketball game.
 * @author Hyeokjin Jin
 * @version CS 1331 HW06
 */
public class BasketballGame extends SportsGame {

    private String league;

    /**
     * BasketballGame constructor that takes in venue, start time, start date, score1, score2,
     * number of seats left, and league name.
     * @param venue The location of the game
     * @param startTime Start time of the game
     * @param startDate Start date of the game
     * @param score1 Score of the first team
     * @param score2 Score of the second team
     * @param seatsLeft Number of seats left at the game
     * @param league The name of league the basketball teams are apart of
     */
    public BasketballGame(String venue, String startTime, String startDate,
                          int score1, int score2, int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("league cannot be null or blank.");
        } else {
            this.league = league.trim();
        }
    }

    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), this.league);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        BasketballGame other = (BasketballGame) o;
        return (this.league.equals(other.league)
                && super.equals(other));
    }
}
