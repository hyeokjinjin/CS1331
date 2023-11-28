import java.util.ArrayList;

/**
 * Class that defines Olivia's states and behaviors.
 * @author Hyeokjin Jin
 * @version HW05 CS1331 11/01/23
 */
public class Olivia {

    private static double budget;
    private static ArrayList<Media> cart = new ArrayList<>();
    private static boolean canUseConsole;

    /**
     * Method that defines Olivia adding a media item to her cart.
     * @param item Media that Olivia will add to her cart
     * @param store The Blockbuster store that Olivia is shopping at
     * @return Boolean depending on if the item is added to Olivia's cart
     */
    public static boolean addToCart(Media item, Blockbuster store) {
        if (item instanceof VideoGame) {
            if (((VideoGame) item).getNeedsConsole() && !canUseConsole) {
                return false;
            }
        }
        if (budget >= item.getRentalPrice() && store.findMedia(item) != null) {
            budget -= item.getRentalPrice();
            cart.add(store.removeMedia(item));
            return true;
        }
        return false;
    }

    /**
     * Method that defines Olivia changing her mind on a media item that is in her cart.
     * @param item Item in Olivia's cart that will be put back
     * @param store The Blockbuster store that Olivia is putting back the media item in
     */
    public static void changeMind(Media item, Blockbuster store) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(item)) {
                store.addMedia(cart.remove(i));
                budget += item.getRentalPrice();
            }
        }
    }


}
