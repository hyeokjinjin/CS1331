import java.util.ArrayList;

/**
 * Class that represents a Blockbuster store that has both video game and movie items to be checked out for customers.
 * @author Hyeokjin Jin
 * @version HW05 CS1331 11/01/23
 */
public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * Default constructor for BlockBuster class.
     */
    public Blockbuster() {
        inventory = new ArrayList<>();
    }

    /**
     * Method that adds the inputted media item to the store's inventory.
     * @param item Media item that will be added to the store's inventory
     */
    public void addMedia(Media item) {
        inventory.add(item);
    }

    /**
     * Method that removes the inputted media item from the store's inventory.
     * @param item Media item that will be removed from the store's inventory
     * @return Media item that was removed from the store's inventory
     */
    public Media removeMedia(Media item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(item)) {
                return inventory.remove(i);
            }
        }
        return null;
    }

    /**
     * Method that sorts the store's inventory in ascending order.
     */
    public void sortMedia() {
        for (int i = 1; i < inventory.size(); i++) {
            Media currentMedia = inventory.get(i);
            int j = i - 1;
            while (j >= 0 && inventory.get(j).compareTo(currentMedia) > 0) {
                inventory.set(j + 1, inventory.get(j));
                j--;
            }
            inventory.set(j + 1, currentMedia);
        }
    }

    /**
     * Method that finds the inputted media item from the store's inventory.
     * @param item Media item that will be found from the store's inventory
     * @return Either null if item is not found or the media item that is found from the store's inventory
     */
    public Media findMedia(Media item) {
        int low = 0;
        int high = inventory.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (inventory.get(mid).equals(item)) {
                return inventory.get(mid);
            }
            if (item.compareTo(inventory.get(mid)) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    /**
     * Method that finds the most popular movie from the store's inventory.
     * @return Movie item that has the most popular rating
     */
    public Movie getMostPopularMovie() {
        Movie mostPopular = null;
        for (Media media : inventory) {
            if (media instanceof Movie) {
                if (mostPopular == null) {
                    mostPopular = (Movie) media;
                }
                if (media.getRating() == mostPopular.getRating() && media.compareTo(mostPopular) < 0) {
                    mostPopular = (Movie) media;
                }
                if (media.getRating() > mostPopular.getRating()) {
                    mostPopular = (Movie) media;
                }
            }
        }
        return mostPopular;
    }



}
