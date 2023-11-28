/**
 * Abstract Class that defines basic behaviors of media items that a customer can check out.
 * @author Hyeokjin Jin
 * @version HW05 CS1331 11/01/23
 */
public abstract class Media implements Comparable<Media> {

    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Media constructor that takes in genre, name, rating, and rental price.
     * @param genre Genre of the media item
     * @param name Name of the media item
     * @param rating Audience rating of the media item
     * @param rentalPrice Price for renting the media item
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Media constructor that takes in genre, name, and rating.
     * @param genre Genre of the media item
     * @param name Name of the media item
     * @param rating Audience rating of the media item
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f", genre, name, rating, rentalPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || (!getClass().equals(o.getClass()))) {
            return false;
        }
        Media other = (Media) o;
        return (genre == other.genre
                && this.name == null ? other.name == null : this.name.equals(other.name)
                && this.rating == other.rating
                && this.rentalPrice == other.rentalPrice);
    }

    @Override
    public int compareTo(Media other) {
        if (this.genre.compareTo(other.genre) != 0) {
            return this.genre.compareTo(other.genre);
        } else if (this.name.compareTo(other.name) != 0) {
            return this.name.compareTo(other.name);
        } else {
            return Integer.valueOf(this.rating).compareTo(other.rating);
        }
    }

    /**
     * Getter method for name field.
     * @return name of the media item
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for rating field.
     * @return Audience rating of the media item
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter method for the rentalPrice field.
     * @return Price for renting the media item
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}
