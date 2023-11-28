/**
 * Class describing a checked exception that is thrown when encountering an invalid ticket.
 * @author Hyeokjin Jin
 * @version CS 1331 HW06
 */
public class InvalidTicketException extends Exception {

    /**
     * Constructor that takes in the exception's message.
     * @param message String representing the message of the exception
     */
    public InvalidTicketException(String message) {
        super(message);
    }

    /**
     * No argument constructor that has default message "Invalid ticket".
     */
    public InvalidTicketException() {
        super("Invalid ticket");
    }

}
