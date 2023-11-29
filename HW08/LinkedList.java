import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic class that represents a LinkedList.
 * @author Hyeokjin Jin
 * @version HW08 CS1331
 * @param <T> The type of elements that the LinkedList will hold.
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * No argument constructor that sets the head Node to null and size to be zero.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Constructor that takes in an Array containing type T and each element to the end of the LinkedList.
     * @param data Array containing elements of type T that will be added to LinkedList.
     */
    public LinkedList(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        for (T datum : data) {
            if (datum == null) {
                throw new IllegalArgumentException("Input array cannot contain any null elements.");
            }
            add(datum);
        }
    }

    /**
     * Getter method for head Node.
     * @return head Node of the LinkedList.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Method that takes the LinkedList and returns an array consisting of the elements found in the LinkedList.
     * @return Array containing all elements from the LinkedList.
     */
    public T[] toArray() {
        T[] returnArray = (T[]) new Object[size];
        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            returnArray[index++] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return returnArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }

        Node<T> addedNode = new Node<>(element);

        if (head == null) {
            head = addedNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(addedNode);
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null && (index > size() || index < 0)) {
            throw new IndexOutOfBoundsException("Invalid index and element cannot be null.");
        } else if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index.");
        } else if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }

        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            int currentIndex = 0;
            Node<T> previousNode = head;
            while (currentIndex < (index - 1)) {
                previousNode = previousNode.getNext();
                currentIndex++;
            }

            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty.");
        }

        T removedData = head.getData();
        head = head.getNext();
        size--;
        return removedData;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (isEmpty() && (index >= size || index < 0)) {
            throw new NoSuchElementException("Index is invalid and list is empty.");
        } else if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty.");
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid Index.");
        }

        T removedElement;
        if (index == 0) {
            removedElement = head.getData();
            head = head.getNext();
        } else {
            Node<T> previousNode = head;
            int currentIndex = 0;
            while (currentIndex < (index - 1)) {
                previousNode = previousNode.getNext();
                currentIndex++;
            }

            Node<T> removedNode = previousNode.getNext();
            previousNode.setNext(removedNode.getNext());
            removedElement = removedNode.getData();
        }
        size--;
        return removedElement;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }

        Node<T> currentNode = head;
        int nodeIndex = 0;
        while (currentNode.getNext() != null) {
            if (currentNode.getData().equals(element)) {
                remove(nodeIndex);
                return currentNode.getData();
            }
            nodeIndex++;
            currentNode = currentNode.getNext();
        }
        if (currentNode.getNext() == null && currentNode.getData().equals(element)) {
            remove(nodeIndex);
            return currentNode.getData();
        } else {
            throw new NoSuchElementException("Argument element not found in the list.");
        }
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null && (index >= size || index < 0)) {
            throw new IndexOutOfBoundsException("Element cannot be null and index is invalid");
        } else if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is invalid");
        }

        int currentIndex = 0;
        Node<T> currentNode = head;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        T replacedData = currentNode.getData();
        currentNode.setData(element);

        return replacedData;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }

        int currentIndex = 0;
        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            if (currentIndex == index) {
                return iterator.next();
            }
            iterator.next();
            currentIndex++;
        }
        return null;
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
            iterator().next();
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }
}