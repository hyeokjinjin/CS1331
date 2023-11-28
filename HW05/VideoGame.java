/**
 * Class that extend Media class and describes a specific media item, VideoGame.
 * @author Hyeokjin Jin
 * @version HW05 CS1331 11/01/23
 */
public class VideoGame extends Media {

    private int maxPlayers;
    private boolean needsConsole;

    /**
     * VideoGame constructor that takes in genre, name, rating, rental price,
     * max number of players, and boolean describing if the game needs a console.
     * @param genre Genre of the video game item
     * @param name Name of the video game item
     * @param rating Audience rating of the video game item
     * @param rentalPrice Rental price of the video game item
     * @param maxPlayers Max number of players of the video game item
     * @param needsConsole Describes if the video game item needs a console to be played.
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * VideoGame constructor that takes in genre, name, and rating.
     * @param genre Genre of the video game item
     * @param name Name of the video game item
     * @param rating Audience rating of the video game item
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    @Override
    public String toString() {
        return String.format("%s, Players: %d, %s need console",
                super.toString(), maxPlayers, needsConsole ? "does" : "does not");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        VideoGame other = (VideoGame) o;
        return (super.equals(other)
                && this.maxPlayers == other.maxPlayers
                && this.needsConsole == other.needsConsole);
    }

    /**
     * Getter method for whether the video game item needs a console to be played.
     * @return Boolean describing if the video game item needs a console to be played
     */
    public boolean getNeedsConsole() {
        return needsConsole;
    }
}
