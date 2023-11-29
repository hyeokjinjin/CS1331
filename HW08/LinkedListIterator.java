import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class that represents an iterator that iterates over a LinkedList.
 * @author Hyeokjin Jin
 * @version HW08 CS1331
 * @param <T> The type of elements that the LinkedList will store and be iterated through.
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * Constructor for LinkedListIterator object that takes in a LinkedList that will be iterated.
     * @param iterated The LinkedList that will be iterated through.
     */
    public LinkedListIterator(LinkedList<T> iterated) {
        if (iterated == null) {
            throw new IllegalArgumentException("LinkedList cannot be null.");
        }
        next = iterated.getHead();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate over.");
        }
        T data = next.getData();
        next = next.getNext();
        return data;
    }
}
