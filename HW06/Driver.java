import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Driver class.
 *
 * @author David Andrews
 * @version 1.0
 */
public class Driver extends TestRunner {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        System.exit(driver.runTests() > 0 ? 1 : 0); // have to stop potential infinite loops
    }

    // manage temporary test context better in the future
    private static void makeTicketsFile(String... extraLines) throws Exception {
        try (PrintWriter out = new PrintWriter("TestTickets.csv")) {
            for (SportsGame game : makeDummySportsGames()) {
                out.println(game.toString());
            }
            for (String line : extraLines) {
                out.println(line);
            }
        }
    }

    private static void deleteTicketsFile() {
        new File("TestTickets.csv").delete();
    }

    private static ArrayList<SportsGame> makeDummySportsGames() {
        ArrayList<SportsGame> games = new ArrayList<>();
        games.add(new BasketballGame("Madison Square Garden", "8:00 PM", "2021-11-01", 102, 97,
                18000, "NBA"));
        games.add(
                new FootballGame("MetLife Stadium", "1:00 PM", "2021-11-07", 24, 27, 75000, "NFL"));
        games.add(new BasketballGame("United Center", "7:30 PM", "2021-11-10", 99, 101, 21000,
                "NBA"));
        games.add(new FootballGame("Lambeau Field", "8:20 PM", "2021-11-14", 30, 28, 81000, "NFL"));
        games.add(new BasketballGame("Barclays Center", "6:00 PM", "2021-11-15", 110, 105, 17732,
                "NBA"));
        games.add(
                new FootballGame("Soldier Field", "12:00 PM", "2021-11-21", 21, 24, 61500, "NFL"));
        games.add(new BasketballGame("TD Garden", "7:45 PM", "2021-11-22", 108, 99, 19156, "NBA"));
        games.add(new FootballGame("AT&T Stadium", "4:25 PM", "2021-11-25", 31, 26, 80000, "NFL"));
        games.add(new BasketballGame("Wells Fargo Center", "8:00 PM", "2021-11-29", 115, 112, 20478,
                "NBA"));
        games.add(
                new FootballGame("Levi's Stadium", "5:00 PM", "2021-12-05", 23, 20, 68500, "NFL"));
        return games;
    }

    @Test
    private void testSportsGameInvalidValues() {
        try {
            new BasketballGame(null, "time", "date", 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a null venue");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("", "time", "date", 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a blank venue");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", null, "date", 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a null startTime");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "", "date", 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a blank startTime");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", null, 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a null startDate");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "", 0, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a blank startDate");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "date", -1, 0, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a negative score1");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "date", 0, -1, 0, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a negative score2");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "date", 0, 0, -1, "league");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a negative seatsLeft");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "date", 0, 0, 0, null);
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a null league");
        } catch (IllegalArgumentException e) {
        }

        try {
            new BasketballGame("venue", "time", "date", 0, 0, 0, "");
            Assert.assertTrue(false,
                    "SportsGame constructor should throw an IllegalArgumentException when given a null league");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testSportsGameToString() {
        ArrayList<SportsGame> games = makeDummySportsGames();

        SportsGame basketballGame = games.get(0);
        Assert.assertEqual(
                "BasketballGame,Madison Square Garden,8:00 PM,2021-11-01,102,97,18000,NBA",
                basketballGame.toString(), "BasketballGame toString() is incorrect");

        SportsGame footballGame = games.get(1);
        Assert.assertEqual("FootballGame,MetLife Stadium,1:00 PM,2021-11-07,24,27,75000,NFL",
                footballGame.toString(), "FootballGame toString() is incorrect");
    }

    @Test
    private void testSportsGameEquals() {
        SportsGame basketballGame1 = new BasketballGame("Madison Square Garden", "8:00 PM",
                "2021-11-01", 102, 97, 18000, "NBA");
        SportsGame basketballGame2 = new BasketballGame("Madison Square Garden", "8:00 PM",
                "2021-11-01", 102, 97, 18000, "NBA");
        SportsGame basketballGame3 = new BasketballGame("Madison Square Garden", "8:00 PM",
                "2021-11-01", 102, 97, 18000, "NBA");

        // reflexive
        Assert.assertTrue(basketballGame1.equals(basketballGame1),
                "SportsGame equals() is not reflexive");

        // symmetric
        Assert.assertTrue(basketballGame1.equals(basketballGame2),
                "SportsGame equals() is not symmetric");
        Assert.assertTrue(basketballGame2.equals(basketballGame1),
                "SportsGame equals() is not symmetric");

        // transitive
        Assert.assertTrue(basketballGame2.equals(basketballGame3),
                "SportsGame equals() is not transitive");
        Assert.assertTrue(basketballGame1.equals(basketballGame3),
                "SportsGame equals() is not transitive");
    }

    @Test
    private void testInvalidTicket() {
        InvalidTicketException e1 = new InvalidTicketException("Ticket Exception");
        Assert.assertEqual("Ticket Exception", e1.getMessage(),
                "InvalidTicketException message is incorrect");

        InvalidTicketException e2 = new InvalidTicketException();
        Assert.assertEqual("Invalid ticket", e2.getMessage(),
                "InvalidTicketException message is incorrect");
    }

    @Test
    private void testRetrieveGamesInvalidPath() throws Exception {
        makeTicketsFile();
        try {
            Tickets.retrieveGames(null);
            Assert.assertTrue(false,
                    "retrieveGames() should throw a FileNotFoundException when given a null path");
        } catch (FileNotFoundException e) {
        }

        try {
            Tickets.retrieveGames("");
            Assert.assertTrue(false,
                    "retrieveGames() should throw a FileNotFoundException when given a blank path");
        } catch (FileNotFoundException e) {
        }

        try {
            Tickets.retrieveGames("nonexistent.csv");
            Assert.assertTrue(false,
                    "retrieveGames() should throw a FileNotFoundException when path name is valid but nonexistent");
        } catch (FileNotFoundException e) {
        }
        deleteTicketsFile();
    }

    @Test
    private void testRetrieveGamesValidLines() throws Exception {
        try {
            makeTicketsFile();

            ArrayList<SportsGame> games = Tickets.retrieveGames("TestTickets.csv");

            Assert.assertEqual(makeDummySportsGames(), games, "retrieveGames() is incorrect");
        } finally {
            deleteTicketsFile();
        }
    }

    @Test
    private void testRetrieveGamesInvalidLine() throws Exception {
        try {
            makeTicketsFile("SoccerGame,MBS,13:31,01-31-1331,3,0,6,MLS");

            try {
                Tickets.retrieveGames("TestTickets.csv");
                Assert.assertTrue(false, "retrieveGames() should throw an InvalidTicketException");
            } catch (InvalidTicketException e) {
            }
        } finally {
            deleteTicketsFile();
        }
    }

    @Test
    private void testPurchaseTicketsInvalidPath() throws Exception {
        try {
            Tickets.purchaseTickets(null, new ArrayList<>());
            Assert.assertTrue(false,
                    "purchaseTickets() should throw an IllegalArgumentException when given a null path");
        } catch (IllegalArgumentException e) {
        }

        try {
            Tickets.purchaseTickets("", new ArrayList<>());
            Assert.assertTrue(false,
                    "purchaseTickets() should throw an IllegalArgumentException when given a blank path");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testPurchaseTicketsInvalidNewFile() throws Exception {
        try {
            Tickets.purchaseTickets("/path/that/does/not/exist/file.txt", new ArrayList<>());
            Assert.assertTrue(false, "purchaseTickets() should throw an IOException");
        } catch (IOException e) {
        }
    }

    @Test
    private void testPurchaseTicketsValid() throws Exception {
        try {
            ArrayList<SportsGame> games = makeDummySportsGames();

            Tickets.purchaseTickets("temp.csv", games);

            ArrayList<SportsGame> purchasedGames = Tickets.retrieveGames("temp.csv");

            Assert.assertEqual(games, purchasedGames, "purchaseTickets() is incorrect");
        } finally {
            new File("temp.csv").delete();
        }
    }

    @Test
    private void testPurchaseTicketsOutOfSeats() throws Exception {
        try {
            ArrayList<SportsGame> games = makeDummySportsGames();

            games.add(new BasketballGame("venue", "time", "date", 0, 0, 0, "league"));

            Tickets.purchaseTickets("temp.csv", games);

            ArrayList<SportsGame> purchasedGames = Tickets.retrieveGames("temp.csv");

            Assert.assertEqual(makeDummySportsGames(), purchasedGames,
                    "purchaseTickets() is incorrect");
        } finally {
            new File("temp.csv").delete();
        }
    }

    @Test
    private void testFindTicketsInvalidPath() throws Exception {
        try {
            Tickets.findTickets(null, makeDummySportsGames().get(0));
            Assert.assertTrue(false,
                    "findTickets() should throw a FileNotFoundException with a null path");
        } catch (FileNotFoundException e) {
        }

        try {
            Tickets.findTickets("", makeDummySportsGames().get(0));
            Assert.assertTrue(false,
                    "findTickets() should throw a FileNotFoundException with a blank path");
        } catch (FileNotFoundException e) {
        }
    }

    @Test
    private void testFindTicketsValid() throws Exception {
        try {
            makeTicketsFile();
            ArrayList<Integer> indices =
                    Tickets.findTickets("TestTickets.csv", makeDummySportsGames().get(0));
            Assert.assertEqual(new ArrayList<>(Arrays.asList(0)), indices,
                    "findTickets() is incorrect");

            makeTicketsFile();

            Tickets.purchaseTickets("TestTickets.csv", makeDummySportsGames());

            indices = Tickets.findTickets("TestTickets.csv", makeDummySportsGames().get(0));

            Assert.assertEqual(new ArrayList<>(Arrays.asList(0, 10)), indices,
                    "findTickets() is incorrect");

            makeTicketsFile();

            try {
                Tickets.findTickets("TestTickets.csv",
                        new BasketballGame("venue", "time", "date", 0, 0, 0, "league"));
                Assert.assertTrue(false,
                        "findTickets() should throw an InvalidTicketException for a nonexistent SportsGame");
            } catch (InvalidTicketException e) {
            }
        } finally {
            deleteTicketsFile();
        }
    }

    @Test
    private void testAttendGameInvalidPath() throws Exception {
        try {
            Tickets.attendGame(null, makeDummySportsGames().get(0));
            Assert.assertTrue(false,
                    "attendGame() should throw a FileNotFoundException with a null path");
        } catch (FileNotFoundException e) {
        }

        try {
            Tickets.attendGame("", makeDummySportsGames().get(0));
            Assert.assertTrue(false,
                    "attendGame() should throw a FileNotFoundException with a blank path");
        } catch (FileNotFoundException e) {
        }

        try {
            Tickets.attendGame("", makeDummySportsGames().get(0));
            Assert.assertTrue(false,
                    "attendGame() should throw a FileNotFoundException when path is valid but nonexistent");
        } catch (FileNotFoundException e) {
        }
    }

    @Test
    private void testAttendGameValid() throws Exception {
        try {
            makeTicketsFile();

            Tickets.attendGame("TestTickets.csv", makeDummySportsGames().get(0));

            ArrayList<SportsGame> games = Tickets.retrieveGames("TestTickets.csv");

            Assert.assertEqual(makeDummySportsGames().subList(1, 10), games,
                    "attendGame() is incorrect");
        } finally {
            deleteTicketsFile();
        }
    }

    @Test
    private void testAttendGameInvalidTicket() throws Exception {
        try {
            makeTicketsFile();
            Tickets.attendGame("TestTickets.csv",
                    new FootballGame("venue", "time", "date", 0, 0, 0, "performer"));
            Assert.assertTrue(false,
                    "Tickets.attendGame() should throw InvalidTicketException for not finding a SportsGame");
        } catch (InvalidTicketException e) {
        } finally {
            deleteTicketsFile();
        }
    }
}


class TestRunner {
    public int runTests() {
        List<Method> tests = getTests();

        System.out.printf("Running %d test%s\n", tests.size(), tests.size() == 1 ? "" : "s");

        long startTime = System.currentTimeMillis();

        int passed = 0;
        int failed = 0;

        LinkedHashMap<Method, String> failures = new LinkedHashMap<>();

        for (Method test : tests) {
            System.out.printf("Running " + test.getName() + " ... ");
            String stdout = invokeTestMethod(test, 1000);
            if (stdout == null) {
                System.out.println("ok");
                passed++;
                continue;
            }
            System.out.println("FAILED");
            failures.put(test, stdout);
            failed++;
        }

        System.out.println();

        if (!failures.isEmpty()) {
            System.out.println("Failures:");

            System.out.println();

            for (Method test : failures.keySet()) {
                System.out.println(" ---- " + test.getName() + " ---- ");
                System.out.print(failures.get(test));
                System.out.println();
            }

            System.out.println("Failures:");
            for (Method test : failures.keySet()) {
                System.out.println("    " + test.getName());
            }

            System.out.println();
        }

        System.out.printf("Summary: %s. %d passed, %d failed. finished in %.2fs\n",
                failed == 0 ? "ok" : "FAILED", passed, failed,
                (System.currentTimeMillis() - startTime) / 1000.0);

        return failed;
    }

    private List<Method> getTests() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .collect(Collectors.toList());
    }

    private String invokeTestMethod(Method method, long timeoutInMillis) {
        method.setAccessible(true);
        final boolean[] failed = {false};
        final boolean[] timeoutOccurred = {false};

        Thread testThread = new Thread(() -> {
            try {
                method.invoke(this);
            } catch (Exception e) {
                e.getCause().printStackTrace();
                failed[0] = true;
            }
        });

        String stdout = captureConsole(() -> {
            testThread.start();
            try {
                testThread.join(timeoutInMillis);
                if (testThread.isAlive()) {
                    testThread.interrupt();
                    timeoutOccurred[0] = true;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                failed[0] = true;
            }
        });

        if (failed[0] || timeoutOccurred[0]) {
            return stdout + (timeoutOccurred[0]
                    ? "(Did not finish within the allowed time and may contain an infinite loop)\n"
                    : "");
        }
        return null;
    }

    // maybe just make captureConsole() and stopCapturingConsole() methods instead? lambdas are
    // annoying with scope and capturing
    protected static String captureConsole(Runnable r) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));

        r.run();

        System.setOut(originalOut);
        System.setErr(originalErr);

        return out.toString() + err.toString();
    }

    protected static <T> Field getField(Class<T> className, String fieldName) {
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

    protected static Object getValue(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
        return null;
    }

    protected static void setValue(Object obj, Field field, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
    }

    protected static Object getValue(Object obj, String fieldName) {
        return getValue(obj, getField(obj.getClass(), fieldName));
    }

    protected static void setValue(Object obj, String fieldName, Object value) {
        setValue(obj, getField(obj.getClass(), fieldName), value);
    }

    protected static Object getStaticValue(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
        return null;
    }

    protected static void setStaticValue(Field field, Object value) {
        try {
            field.set(null, value);
        } catch (IllegalAccessException e) {
            System.err.println("Cannot obtain access to the " + field.getName() + " field!");
            System.exit(1);
        }
    }

    protected static Object getStaticValue(Class<?> className, String fieldName) {
        return getStaticValue(getField(className, fieldName));
    }

    protected static void setStaticValue(Class<?> className, String fieldName, Object value) {
        setStaticValue(getField(className, fieldName), value);
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface Test {
}


class Assert {
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertEqual(Object expected, Object actual, String message) {
        if (expected == null && actual != null || !expected.equals(actual)) {
            throw new AssertionError(
                    String.format("%s\nExpected '%s' but got '%s'", message, expected, actual));
        }
    }

    public static void assertInstanceOf(Object obj, Class<?> className, String message) {
        if (obj == null || !className.isInstance(obj)) {
            throw new AssertionError(String.format("%s\nExpected instance of '%s' but got '%s'",
                    message, className.getName(), obj == null ? "null" : obj.getClass().getName()));
        }
    }
}
