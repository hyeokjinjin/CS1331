import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> next;


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
