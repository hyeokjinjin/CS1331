/**
 * Class that extend Media class and describes a specific media item, Movie.
 * @author Hyeokjin Jin
 * @version HW05 CS1331 11/01/23
 */
public class Movie extends Media {
    private int runtime;

    /**
     * Movie constructor that takes in genre, name, rating, rental price, and runtime of the Movie item.
     * @param genre Genre of the movie item
     * @param name Name of the movie item
     * @param rating Audience rating of the movie item
     * @param rentalPrice Rental price of the movie item
     * @param runtime Runtime of the movie item
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Movie constructor that takes in genre, name, and rating of the Movie item.
     * @param genre Genre of the movie item
     * @param name Name of the movie item
     * @param rating Audience rating of the movie item
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    @Override
    public String toString() {
        return String.format("%s, Runtime: %d", super.toString(), this.runtime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || (!getClass().equals(o.getClass()))) {
            return false;
        }
        Movie other = (Movie) o;
        return (super.equals(other)
                && this.runtime == other.runtime);
    }
}
