/**
 * Subclass of SportGame that describes a football game.
 * @author Hyeokjin Jin
 * @version CS 1331 HW06
 */
public class FootballGame extends SportsGame {

    private String performer;

    /**
     * FootballGame constructor that takes in venue, start time, start date, score1, score2,
     * number of seats left, and performer name.
     * @param venue The location of the game
     * @param startTime Start time of the game
     * @param startDate Start date of the game
     * @param score1 Score of the first team
     * @param score2 Score of the second team
     * @param seatsLeft Number of seats left at the game
     * @param performer The name of halftime performer
     */
    public FootballGame(String venue, String startTime, String startDate,
                        int score1, int score2, int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (performer == null || performer.isBlank()) {
            throw new IllegalArgumentException("performer cannot be null or blank.");
        } else {
            this.performer = performer.trim();
        }
    }

    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), this.performer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        FootballGame other = (FootballGame) o;
        return (this.performer.equals(other.performer)
                && super.equals(other));
    }
}

