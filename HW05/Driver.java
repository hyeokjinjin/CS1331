import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Driver class.
 *
 * @author David Andrews
 * @version 1.0
 */
public class Driver {
    private static ArrayList<String> testsFailed = new ArrayList<>();

    static {
        try {
            assert false;
            System.err.println("You have not enabled assertions!");
            System.err.println(
                    "Do this by running `java -ea Driver` or adding `-ea` to your VM options.");
            System.exit(1);
        } catch (AssertionError ignored) {
        }
    }

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Blockbuster store = new Blockbuster();
        stock(store);
        shopAt(store);
        if (testsFailed.isEmpty()) {
            System.out.println("\nAll tests passed! :)");
        } else {
            System.out.println("\nThe following tests failed:");
            for (String test : testsFailed) {
                System.out.println(test);
            }
        }
    }

    /**
     * @param store The store to stock.
     */
    public static void stock(Blockbuster store) {
        // test that constructors and toString() are working
        Movie testMovie = new Movie(Genre.ACTION, "Test Movie", 0);
        VideoGame testVideoGame = new VideoGame(Genre.ACTION, "Test Video Game", 0);
        assertEqual("Test Movie toString()", testMovie.toString(),
                "Genre: ACTION, Name: Test Movie, Rating: 0, Rental Price: $5.00, Runtime: 111",
                "Movie toString() is wrong");
        assertEqual("Test VideoGame toString()", testVideoGame.toString(),
                "Genre: ACTION, Name: Test Video Game, Rating: 0, "
                        + "Rental Price: $5.00, Players: 2, does not need console",
                "VideoGame toString() is wrong");

        // test equals
        // reflexive
        assertEqual("equals() reflexive test", testMovie, testMovie,
                "Movie equals() is not reflexive");
        Movie testMovie2 = new Movie(Genre.ACTION, "Test Movie", 0);
        // symmetric
        assertEqual("equals() symmetric test 1", testMovie, testMovie2,
                "Movie equals() is not symmetric");
        assertEqual("equals() symmetric test 2", testMovie2, testMovie,
                "Movie equals() is not symmetric");
        // transitive
        Movie testMovie3 = new Movie(Genre.ACTION, "Test Movie", 0);
        assertEqual("equals() transitive test 1", testMovie2, testMovie3,
                "Movie equals() is not transitive");
        assertEqual("equals() transitive test 2", testMovie, testMovie3,
                "Movie equals() is not transitive");

        // make the movies and video games
        Movie avatar = new Movie(Genre.SCI_FI, "Avatar", 4, 17.99, 162);
        Movie endgame = new Movie(Genre.ACTION, "Avengers: Endgame", 5, 26.64, 182);
        Movie avatarWayOfWater = new Movie(Genre.SCI_FI, "Avatar: Way of Water", 4, 29.99, 192);
        Movie titanic = new Movie(Genre.ROMANCE, "Titanic", 5, 8.99, 194);
        Movie shrek = new Movie(Genre.FANTASY, "Shrek", 5, 8.45, 90);

        VideoGame minecraft = new VideoGame(Genre.ACTION, "Minecraft", 5, 29.99, 4, true);
        VideoGame amongUs = new VideoGame(Genre.MYSTERY, "Among Us", 4, 0.00, 10, false);
        VideoGame fnaf = new VideoGame(Genre.HORROR, "Five Nights at Freddy's", 5, 19.99, 1, false);
        VideoGame theStanleyParable =
                new VideoGame(Genre.COMEDY, "The Stanley Parable", 5, 14.99, 1, false);

        store.addMedia(avatar);
        store.addMedia(endgame);
        store.addMedia(avatarWayOfWater);
        store.addMedia(titanic);
        store.addMedia(shrek);
        store.addMedia(minecraft);
        store.addMedia(amongUs);
        store.addMedia(fnaf);
        store.addMedia(theStanleyParable);

        // check that inventory is correct
        Field inventoryField = getField(Blockbuster.class, "inventory");
        assertEqual("Check store inventory", getValue(store, inventoryField).toString(),
                "[Genre: SCI_FI, Name: Avatar, Rating: 4, Rental Price: $17.99, Runtime: 162, "
                        + "Genre: ACTION, Name: Avengers: Endgame, Rating: 5, Rental Price: $26.64, Runtime: 182,"
                        + " Genre: SCI_FI, Name: Avatar: Way of Water, Rating: 4, Rental Price: $29.99, Runtime: 192,"
                        + " Genre: ROMANCE, Name: Titanic, Rating: 5, Rental Price: $8.99, Runtime: 194,"
                        + " Genre: FANTASY, Name: Shrek, Rating: 5, Rental Price: $8.45, Runtime: 90,"
                        + " Genre: ACTION, Name: Minecraft, Rating: 5, Rental Price: $29.99, Players: 4,"
                        + " does need console," + " Genre: MYSTERY, Name: Among Us, Rating: 4,"
                        + " Rental Price: $0.00, Players: 10, does not need console,"
                        + " Genre: HORROR, Name: Five Nights at"
                        + " Freddy's, Rating: 5, Rental Price: $19.99, Players: 1, does not need console,"
                        + " Genre: COMEDY, Name: The Stanley"
                        + " Parable, Rating: 5, Rental Price: $14.99, Players: 1, does not need console]",
                "Inventory is not correct");

        // check that the inventory is sorted correctly
        store.sortMedia();
        assertEqual("Check sorted store inventory", getValue(store, inventoryField).toString(),
                "[Genre: ACTION, Name: Avengers: Endgame, Rating: 5, Rental Price: $26.64, Runtime: 182,"
                        + " Genre: ACTION, Name: Minecraft, Rating: 5,"
                        + " Rental Price: $29.99, Players: 4, does need console,"
                        + " Genre: COMEDY, Name: The Stanley Parable,"
                        + " Rating: 5, Rental Price: $14.99, Players: 1, does not need console,"
                        + " Genre: FANTASY, Name: Shrek, Rating: 5, Rental Price: $8.45, Runtime: 90,"
                        + " Genre: HORROR, Name: Five Nights at Freddy's,"
                        + " Rating: 5, Rental Price: $19.99, Players: 1, does not need console,"
                        + " Genre: MYSTERY, Name: Among Us, Rating: 4,"
                        + " Rental Price: $0.00, Players: 10, does not need console,"
                        + " Genre: ROMANCE, Name: Titanic, Rating: 5, Rental Price: $8.99, Runtime: 194,"
                        + " Genre: SCI_FI, Name: Avatar, Rating: 4, Rental Price: $17.99, Runtime: 162,"
                        + " Genre: SCI_FI, Name: Avatar: Way of Water, Rating: 4, Rental Price: $29.99, Runtime: 192]",
                "Inventory is not sorted correctly");

        assertEqual("Check most popular movie", store.getMostPopularMovie(),
                new Movie(Genre.ACTION, "Avengers: Endgame", 5, 26.64, 182),
                "getMostPopularMovie() is not working");
    }

    /**
     * @param store The store to shop at.
     */
    public static void shopAt(Blockbuster store) {
        // do a bit of illegalness to get access to the private fields in Olivia
        Field budgetField = getField(Olivia.class, "budget");
        Field cartField = getField(Olivia.class, "cart");
        Field canUseConsoleField = getField(Olivia.class, "canUseConsole");

        setStaticValue(budgetField, 50.0);
        setStaticValue(cartField, new ArrayList<Media>());
        setStaticValue(canUseConsoleField, false);

        assertEqual("Add Avatar to cart",
                Olivia.addToCart(new Movie(Genre.SCI_FI, "Avatar", 4, 17.99, 162), store), true,
                "Olivia.addToCart() is not working, Olivia should be able to add Avatar to cart");

        assertEqual("Add Five Nights at Freddy's to cart",
                Olivia.addToCart(
                        new VideoGame(Genre.HORROR, "Five Nights at Freddy's", 5, 19.99, 1, false),
                        store),
                true,
                "Olivia.addToCart() is not working, Olivia should be able to add Five Nights at Freddy's to cart");

        assertEqual("Add Minecraft to cart",
                Olivia.addToCart(new VideoGame(Genre.ACTION, "Minecraft", 5, 29.99, 4, true),
                        store),
                false, "Olivia.addToCart() is not working, Olivia cannot play console games");

        assertEqual("Add Half Life 3 to cart",
                Olivia.addToCart(new VideoGame(Genre.SCI_FI, "Half Life 3", 5), store), false,
                "Olivia.addToCart() is not working, Half Life 3 will never be released");

        assertEqual("Add Shrek to cart",
                Olivia.addToCart(new Movie(Genre.FANTASY, "Shrek", 5, 8.45, 90), store), true,
                "Olivia.addToCart() is not working, Olivia should be able to add Shrek to cart");

        Olivia.changeMind(
                new VideoGame(Genre.HORROR, "Five Nights at Freddy's", 5, 19.99, 1, false), store);

        assertEqual("Add Avengers: Endgame to cart",
                Olivia.addToCart(new Movie(Genre.ACTION, "Avengers: Endgame", 5, 26.64, 182),
                        store),
                false, "Olivia.addToCart() is not working,"
                        + " Olivia does not have enough money to add Avengers: Endgame to cart");

        assertEqual("Check budget", Math.abs((double) getStaticValue(budgetField) - 23.56) < 1e-6,
                true,
                "Olivia.addToCart() or Olivia.changeMind() is not working, Olivia should have $23.56 left");

        assertEqual("Check cart", getStaticValue(cartField).toString(),
                "[Genre: SCI_FI, Name: Avatar, Rating: 4, Rental Price: $17.99, Runtime: 162,"
                        + " Genre: FANTASY, Name: Shrek, Rating: 5, Rental Price: $8.45, Runtime: 90]",
                "Olivia.addToCart() or Olivia.changeMind() is not working, Olivia's cart is not correct");

        assertEqual("Check store inventory after shopping",
                getValue(store, getField(Blockbuster.class, "inventory")).toString(),
                "[Genre: ACTION, Name: Avengers: Endgame, Rating: 5, Rental Price: $26.64, Runtime: 182,"
                        + " Genre: ACTION, Name: Minecraft, Rating: 5,"
                        + " Rental Price: $29.99, Players: 4, does need console,"
                        + " Genre: COMEDY, Name: The Stanley Parable,"
                        + " Rating: 5, Rental Price: $14.99, Players: 1, does not need console,"
                        + " Genre: MYSTERY, Name: Among Us, Rating: 4,"
                        + " Rental Price: $0.00, Players: 10, does not need console,"
                        + " Genre: ROMANCE, Name: Titanic, Rating: 5, Rental Price: $8.99, Runtime: 194,"
                        + " Genre: SCI_FI, Name: Avatar: Way of Water, Rating: 4, Rental Price: $29.99, Runtime: 192,"
                        + " Genre: HORROR, Name: Five Nights at Freddy's, Rating: 5,"
                        + " Rental Price: $19.99, Players: 1, does not need console]",
                "Olivia.addToCart() or Blockbuster.addMedia() is not working, the store's inventory is not correct");
    }

    private static void assertEqual(String testName, Object got, Object expected, String message) {
        try {
            assert got.equals(expected);
            System.out.printf("%s passed!\n", testName);
        } catch (AssertionError error) {
            System.err.println("================");
            System.err.println(":( " + testName + " failed: " + message + ".\n\nExpected \""
                    + expected.toString() + "\"\n\nbut got \"" + got.toString() + "\"");
            System.err.println();
            error.printStackTrace();
            System.err.println("================");
            testsFailed.add(testName);
        }
    }

    private static <T> Field getField(Class<T> className, String fieldName) {
        try {
            Field field = className.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            System.err.println("You do not have a " + fieldName + " field in Olivia!");
            System.exit(1);
        }
        return null;
    }

    private static Object getValue(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
        return null;
    }

    private static Object getStaticValue(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
        return null;
    }

    private static void setStaticValue(Field field, Object value) {
        try {
            field.set(null, value);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
    }
}
