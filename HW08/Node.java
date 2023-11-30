/**
 * Generic Class that describes an individual node.
 * @author Hyeokjin Jin
 * @version HW08 CS1331
 * @param <T> The type of elements utilized in the nodes.
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    /**
     * Constructor for a Node object that takes in element data and address to next Node.
     * @param data The data that is stored within this Node.
     * @param next A reference to the next Node following this Node.
     */
    public Node(T data, Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor for a Node object that takes in element data.
     * @param data The data that is stored within this Node.
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Getter method for data instance field.
     * @return Data stored within this Node.
     */
    public T getData() {
        return data;
    }

    /**
     * Getter method for the next instance field.
     * @return Next Node reference.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter method for the data instance field.
     * @param data Data that will be stored within this Node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Setter method for the next instance field.
     * @param next Next Node reference that this Node will hold.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
