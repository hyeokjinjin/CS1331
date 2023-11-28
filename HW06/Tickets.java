import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that allows user to read and write to database.
 * @author Hyeokjin Jin
 * @version CS 1331 HW06
 */
public class Tickets {

    /**
     * Static method that retrieves all the games and their information from a .csv file.
     * @param filePath Path to the .csv file that is being read
     * @return ArrayList containing SportsGame objects from .csv file
     * @throws FileNotFoundException Exception thrown when file path is null, blank, or not a path to a file
     * @throws InvalidTicketException Exception thrown when game type token is invalid
     */
    public static ArrayList<SportsGame> retrieveGames(String filePath)
            throws FileNotFoundException, InvalidTicketException {
        if (filePath == null || filePath.isBlank()) {
            throw new FileNotFoundException("File path is null or blank.");
        }

        File openedFile = new File(filePath);

        if (!openedFile.isFile()) {
            throw new FileNotFoundException("File path is valid but not a path to a file.");
        }

        ArrayList<SportsGame> gamesList = new ArrayList<>();

        Scanner scan = new Scanner(openedFile);
        try {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                SportsGame game = processInfo(line);
                gamesList.add(game);
            }
        } finally {
            scan.close();
        }

        return gamesList;
    }

    /**
     * Private helper method that processes one line of .csv file.
     * @param line String that represents one line of the .csv file that is being read in retrieveGames method
     * @return SportsGame object that is created after processing one line
     * @throws InvalidTicketException Exception thrown when game type token is invalid
     */
    private static SportsGame processInfo(String line) throws InvalidTicketException {
        String[] tokenList = line.split(",");
        SportsGame game;
        if (tokenList[0].equals("BasketballGame")) {
            game = new BasketballGame(tokenList[1], tokenList[2], tokenList[3],
                    Integer.parseInt(tokenList[4]), Integer.parseInt(tokenList[5]), Integer.parseInt(tokenList[6]),
                    tokenList[7]);
        } else if (tokenList[0].equals("FootballGame")) {
            game = new FootballGame(tokenList[1], tokenList[2], tokenList[3],
                    Integer.parseInt(tokenList[4]), Integer.parseInt(tokenList[5]), Integer.parseInt(tokenList[6]),
                    tokenList[7]);
        } else {
            throw new InvalidTicketException("Invalid game type.");
        }
        return game;
    }

    /**
     * Method that purchases ticket to games and adds game information to .csv file.
     * @param filePath Path to the file being read and written in
     * @param gamesList ArrayList of SportsGames that will be added to file
     * @throws FileNotFoundException Exception thrown when file path is null, blank, or not a path to a file
     * @throws InvalidTicketException Exception thrown when game type token is invalid
     */
    public static void purchaseTickets(String filePath, ArrayList<SportsGame> gamesList)
            throws FileNotFoundException, InvalidTicketException {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path cannot be null or blank.");
        }

        File openedFile = new File(filePath);

        ArrayList<SportsGame> previousGames = new ArrayList<>();
        if (openedFile.length() != 0) {
            previousGames = retrieveGames(filePath);
        }

        PrintWriter writer = new PrintWriter(openedFile);
        try {
            if (!previousGames.isEmpty()) {
                for (SportsGame previousGame : previousGames) {
                    writer.println(previousGame);
                }
            }
            for (SportsGame game : gamesList) {
                if (game.getSeatsLeft() != 0) {
                    writer.println(game);
                }
            }
        } finally {
            writer.close();
        }
    }

    /**
     * Method that finds the indexes of a particular SportsGame object within the .csv file being read.
     * @param filePath Path to the file being read
     * @param gameObject SportsGame object that is being found within the file being read
     * @return ArrayList of Integers containing the indices of the .csv file that contain gameObject
     * @throws FileNotFoundException Exception thrown when file path is null, blank, or not a path to a file
     * @throws InvalidTicketException Exception thrown when inputted SportsGame object is not found
     */
    public static ArrayList<Integer> findTickets(String filePath, SportsGame gameObject)
            throws FileNotFoundException, InvalidTicketException {

        ArrayList<Integer> foundTickets = new ArrayList<>();
        ArrayList<SportsGame> listOfGames = retrieveGames(filePath);

        int lineNumber = 0;
        for (SportsGame game : listOfGames) {
            if (game.equals(gameObject)) {
                foundTickets.add(lineNumber);
            }
            lineNumber++;
        }

        if (foundTickets.isEmpty()) {
            throw new InvalidTicketException("No ticket found for inputted SportsGame object.");
        }
        return foundTickets;
    }

    /**
     * Method that removes the attended games within the .csv file.
     * @param filePath Path to the file being read and written in
     * @param gameObject SportsGame object that is found and removed within the file
     * @throws FileNotFoundException Exception thrown when file path is null, blank, or not a path to a file
     * @throws InvalidTicketException Exception thrown when inputted SportsGame object is not found
     */
    public static void attendGame(String filePath, SportsGame gameObject)
            throws FileNotFoundException, InvalidTicketException {
        if (filePath == null || filePath.isBlank()) {
            throw new FileNotFoundException("File path cannot be null or blank.");
        }

        File openedFile = new File(filePath);

        if (!openedFile.isFile()) {
            throw new FileNotFoundException("File path is valid but not path to file.");
        }

        ArrayList<SportsGame> gameList = retrieveGames(filePath);
        ArrayList<Integer> foundTickets = findTickets(filePath, gameObject);
        for (int index : foundTickets) {
            gameList.remove(index);
        }

        openedFile.delete();
        purchaseTickets(filePath, gameList);
    }

}
