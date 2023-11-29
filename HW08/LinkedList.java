import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO JAVADOC
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public LinkedList(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        for (T datum : data) {
            if (datum == null) {
                throw new IllegalArgumentException("Input array cannot contain any null elements.");
            }
            add(datum); // keep adding to end
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            arr[index++] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return arr;
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

        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index > size && element == null) {
            throw new IndexOutOfBoundsException("Invalid index and element cannot be null.");
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        } else if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }

        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        Node<T> newNode = new Node<>(element);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
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
        if (isEmpty() && index >= size) {
            throw new NoSuchElementException("Index is invalid and list is empty.");
        } else if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty.");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index.");
        }

        int currentIndex = 0;
        Node<T> previousNode = head;
        while (currentIndex < (index - 1)) {
            previousNode = previousNode.getNext();
            currentIndex++;
        }

        Node<T> removedNode = previousNode.getNext();
        previousNode.setNext(removedNode.getNext());
        size--;
        return removedNode.getData();
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Argument element cannot be null.");
        }

        Node<T> currentNode = head;

        while (currentNode.getNext() != null) {
            if (currentNode.getData() == element) {
                return currentNode.getData();
            }
            currentNode = currentNode.getNext();
        }
        throw new NoSuchElementException("Argument element not found in the list.");
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (element == null && index >= size) {
            throw new IndexOutOfBoundsException("Element cannot be null and index is invalid");
        } else if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        } else if (index >= size) {
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
        return null; // FIXME
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        return false; // FIXME
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
        return null; // FIXME
    }
}