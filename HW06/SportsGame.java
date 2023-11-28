/**
 * Abstract class that describes a general sports game.
 * @author Hyeokjin Jin
 * @version CS 1331 HW06
 */
public abstract class SportsGame {

    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;

    /**
     * SportsGame Constructor that takes in venue, start time, start date, score1, score2, and number of seats left.
     * @param venue The location of the game
     * @param startTime Start time of the game
     * @param startDate Start date of the game
     * @param score1 Score of the first team
     * @param score2 Score of the second team
     * @param seatsLeft Number of seats left at the game
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft) {
        if (venue == null || startTime == null || startDate == null
                || venue.isBlank() || startTime.isBlank() || startDate.isBlank()) {
            throw new IllegalArgumentException("venue, startTime, or startDate cannot be null or blank.");
        } else if (score1 < 0 || score2 < 0 || seatsLeft < 0) {
            throw new IllegalArgumentException("score1, score2, or seatsLeft cannot be negative.");
        } else {
            this.venue = venue.trim();
            this.startTime = startTime.trim();
            this.startDate = startDate.trim();
            this.score1 = score1;
            this.score2 = score2;
            this.seatsLeft = seatsLeft;
        }
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d",
                this.venue, this.startTime, this.startDate, this.score1, this.score2, this.seatsLeft);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        SportsGame other = (SportsGame) o;
        return (this.venue.equals(other.venue)
                && this.startTime.equals(other.startTime)
                && this.startDate.equals(other.startDate)
                && this.score1 == other.score1
                && this.score2 == other.score2
                && this.seatsLeft == other.seatsLeft);
    }

    /**
     * Getter method for seatsLeft field.
     * @return seatsLeft
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }
}
