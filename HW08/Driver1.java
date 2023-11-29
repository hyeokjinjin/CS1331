import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Driver class.
 *
 * @author David Andrews
 * @version 1.0
 */
public class Driver1 extends TestRunner {
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Driver1 driver = new Driver1();
        System.exit(driver.runTests() > 0 ? 1 : 0); // have to stop potential infinite loops
    }

    @Test
    private void testNode() {
        Node<Integer> node = new Node<>(1);
        Assert.assertEqual(node.getData(), 1, "Node data should be 1");
        Assert.assertEqual(node.getNext(), null, "Node next should be null");

        Node<Integer> next = new Node<>(2);
        node.setNext(next);

        Assert.assertEqual(node.getNext(), next, "Node next should be next");

        node.getNext().setData(5);

        Assert.assertEqual(node.getNext().getData(), 5, "Node next data should be 5");
    }

    @Test
    private void testInvalidNode() {
        try {
            new Node<>(null);
            Assert.assertTrue(false,
                    "Node constructor should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testFromArrayInvalid() {
        try {
            new LinkedList<>(null);
            Assert.assertTrue(false,
                    "LinkedList constructor should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            new LinkedList<>(new Integer[] {1, 2, 3, null, 5});
            Assert.assertTrue(false,
                    "LinkedList constructor should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testAdd() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});

        Assert.assertEqual(list.getHead().getData(), 1, "Head data should be 1");
        Assert.assertEqual(list.getHead().getNext().getData(), 2, "Head next data should be 2");
        Assert.assertEqual(list.getHead().getNext().getNext().getData(), 3,
                "Head next next data should be 3");
        Assert.assertEqual(list.getHead().getNext().getNext().getNext().getData(), 4,
                "Head next next next data should be 4");
        Assert.assertEqual(list.getHead().getNext().getNext().getNext().getNext().getData(), 5,
                "Head next next next next data should be 5");
    }

    @Test
    private void testSize() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        Assert.assertEqual(list.size(), 5, "list should have size 5");

        LinkedList<Integer> emptyList = new LinkedList<>();
        Assert.assertEqual(emptyList.size(), 0, "list should have size 0");
    }

    @Test
    private void testIterator() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});

        Iterator<Integer> iter = list.iterator();
        ArrayList<Integer> arr = new ArrayList<>();
        while (iter.hasNext()) {
            arr.add(iter.next());
        }
        Assert.assertEqual(arr, Arrays.asList(1, 2, 3, 4, 5),
                "Iterator should return 1, 2, 3, 4, 5");

        try {
            iter.next();
            Assert.assertTrue(false, "Iterator should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    private void testIteratorEmpty() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {});

        Iterator<Integer> iter = list.iterator();
        ArrayList<Integer> arr = new ArrayList<>();
        while (iter.hasNext()) {
            arr.add(iter.next());
        }
        Assert.assertEqual(arr, Arrays.asList(), "Iterator should return nothing");

        try {
            iter.next();
            Assert.assertTrue(false, "Iterator should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    private void testIteratorOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});

        Iterator<Integer> iter = list.iterator();
        ArrayList<Integer> arr = new ArrayList<>();
        while (iter.hasNext()) {
            arr.add(iter.next());
        }
        Assert.assertEqual(arr, Arrays.asList(1), "Iterator should return 1");

        try {
            iter.next();
            Assert.assertTrue(false, "Iterator should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    private void testToArray() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        Assert.assertEqual(list.toArray(), new Integer[] {1, 2, 3, 4, 5},
                "toArray() should return [1, 2, 3, 4, 5]");
    }

    @Test
    private void testToArrayEmpty() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        Assert.assertEqual(emptyList.toArray(), new Integer[] {}, "toArray() should return []");
    }

    @Test
    private void testToArrayOne() {
        LinkedList<Integer> oneElementList = new LinkedList<>(new Integer[] {1});
        Assert.assertEqual(oneElementList.toArray(), new Integer[] {1},
                "toArray() should return [1]");
    }

    @Test
    private void testAddEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        Assert.assertEqual(list.toArray(), new Integer[] {0}, "list should be [0]");
        Assert.assertEqual(list.size(), 1, "list should have size 1");
    }

    @Test
    private void testAddAtBeginning() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        list.add(0, 0);
        Assert.assertEqual(list.toArray(), new Integer[] {0, 1, 2, 3, 4, 5},
                "list should be [0, 1, 2, 3, 4, 5]");
        Assert.assertEqual(list.size(), 6, "list should have size 6");
    }

    @Test
    private void testAddAtIndex() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        list.add(2, 0);
        Assert.assertEqual(list.toArray(), new Integer[] {1, 2, 0, 3, 4, 5},
                "list should be [1, 2, 0, 3, 4, 5]");
        Assert.assertEqual(list.size(), 6, "list should have size 6");
    }

    @Test
    private void testInvalidAdd() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        try {
            list.add(-1, null);
            Assert.assertTrue(false, "add() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.add(6, null);
            Assert.assertTrue(false, "add() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.add(0, null);
            Assert.assertTrue(false, "add() should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            list.add(null);
            Assert.assertTrue(false, "add() should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testRemoveOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});
        int item = list.remove();
        Assert.assertEqual(list.toArray(), new Integer[] {}, "list should be []");
        Assert.assertEqual(item, 1, "item should be 1");
        Assert.assertEqual(list.size(), 0, "list should have size 0");
    }

    @Test
    private void testRemove() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.remove();
        Assert.assertEqual(list.toArray(), new Integer[] {2, 3, 4, 5},
                "list should be [2, 3, 4, 5]");
        Assert.assertEqual(item, 1, "item should be 1");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveAtBeginning() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.remove(0);
        Assert.assertEqual(list.toArray(), new Integer[] {2, 3, 4, 5},
                "list should be [2, 3, 4, 5]");
        Assert.assertEqual(item, 1, "item should be 1");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveAtEnd() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.remove(4);
        Assert.assertEqual(list.toArray(), new Integer[] {1, 2, 3, 4},
                "list should be [1, 2, 3, 4]");
        Assert.assertEqual(item, 5, "item should be 5");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveAtMiddle() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.remove(2);
        Assert.assertEqual(list.toArray(), new Integer[] {1, 2, 4, 5},
                "list should be [1, 2, 4, 5]");
        Assert.assertEqual(item, 3, "item should be 3");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveBeginningElement() {
        LinkedList<String> list = new LinkedList<>(new String[] {"a", "b", "c", "d", "e"});
        String item = list.remove("a");
        Assert.assertEqual(list.toArray(), new String[] {"b", "c", "d", "e"},
                "list should be [b, c, d, e]");
        Assert.assertEqual(item, "a", "item should be a");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveEndElement() {
        LinkedList<String> list = new LinkedList<>(new String[] {"a", "b", "c", "d", "e"});
        String item = list.remove("e");
        Assert.assertEqual(list.toArray(), new String[] {"a", "b", "c", "d"},
                "list should be [a, b, c, d]");
        Assert.assertEqual(item, "e", "item should be e");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveMiddleElement() {
        LinkedList<String> list = new LinkedList<>(new String[] {"a", "b", "c", "d", "e"});
        String item = list.remove("c");
        Assert.assertEqual(list.toArray(), new String[] {"a", "b", "d", "e"},
                "list should be [a, b, d, e]");
        Assert.assertEqual(item, "c", "item should be c");
        Assert.assertEqual(list.size(), 4, "list should have size 4");
    }

    @Test
    private void testRemoveEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.remove();
            Assert.assertTrue(false, "remove() should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    private void testInvalidRemove() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        try {
            list.remove(-1);
            Assert.assertTrue(false, "remove() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.remove(5);
            Assert.assertTrue(false, "remove() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.remove(null);
            Assert.assertTrue(false, "remove() should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            list.remove((Integer) 6);
            Assert.assertTrue(false, "remove() should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    private void testSetBeginning() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.set(0, 0);
        Assert.assertEqual(list.toArray(), new Integer[] {0, 2, 3, 4, 5},
                "list should be [0, 2, 3, 4, 5]");
        Assert.assertEqual(item, 1, "item should be 1");
    }

    @Test
    private void testSetEnd() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        int item = list.set(4, 0);
        Assert.assertEqual(list.toArray(), new Integer[] {1, 2, 3, 4, 0},
                "list should be [1, 2, 3, 4, 0]");
        Assert.assertEqual(item, 5, "item should be 5");
    }

    @Test
    private void testSetEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.set(0, 0);
            Assert.assertTrue(false, "set() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    private void testSetOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});
        int item = list.set(0, 0);
        Assert.assertEqual(list.toArray(), new Integer[] {0}, "list should be [0]");
        Assert.assertEqual(item, 1, "item should be 1");
    }

    @Test
    private void testSetInvalid() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        try {
            list.set(-1, 0);
            Assert.assertTrue(false, "set() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.set(5, 0);
            Assert.assertTrue(false, "set() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.set(0, null);
            Assert.assertTrue(false, "set() should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

        try {
            list.set(-1, null);
            Assert.assertTrue(false, "set() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    private void testGet() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        Assert.assertEqual(list.get(0), 1, "item should be 1");
        Assert.assertEqual(list.get(4), 5, "item should be 5");
        Assert.assertEqual(list.get(2), 3, "item should be 3");
    }

    @Test
    private void testGetEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            list.get(0);
            Assert.assertTrue(false, "get() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    private void testGetOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});
        Assert.assertEqual(list.get(0), 1, "item should be 1");
    }

    @Test
    private void testGetInvalid() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        try {
            list.get(-1);
            Assert.assertTrue(false, "get() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.get(5);
            Assert.assertTrue(false, "get() should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    private void testContains() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        Assert.assertTrue(list.contains(1), "list should contain 1");
        Assert.assertTrue(list.contains(5), "list should contain 5");
        Assert.assertTrue(list.contains(3), "list should contain 3");
        Assert.assertTrue(!list.contains(0), "list should not contain 0");
    }

    @Test
    private void testContainsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertTrue(!list.contains(1), "list should not contain 1");
    }

    @Test
    private void testContainsOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});
        Assert.assertTrue(list.contains(1), "list should contain 1");
        Assert.assertTrue(!list.contains(0), "list should not contain 0");
    }

    @Test
    private void testInvalidContains() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        try {
            list.contains(null);
            Assert.assertTrue(false, "contains() should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    private void testClear() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        list.clear();
        Assert.assertEqual(list.toArray(), new Integer[] {}, "list should be []");
        Assert.assertEqual(list.size(), 0, "list should have size 0");
    }

    @Test
    private void testClearEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        list.clear();
        Assert.assertEqual(list.toArray(), new Integer[] {}, "list should be []");
        Assert.assertEqual(list.size(), 0, "list should have size 0");
    }

    @Test
    private void testClearOne() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1});
        list.clear();
        Assert.assertEqual(list.toArray(), new Integer[] {}, "list should be []");
        Assert.assertEqual(list.size(), 0, "list should have size 0");
    }

    @Test
    private void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>(new Integer[] {1, 2, 3, 4, 5});
        Assert.assertTrue(!list.isEmpty(), "list should not be empty");
    }

    @Test
    private void testIsEmptyEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertTrue(list.isEmpty(), "list should be empty");
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
            String stdout = invokeTestMethod(test, 1_000_000);
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

    public static void assertEqual(Object actual, Object expected, String message) {
        if (expected == null && actual == null) {
            return;
        }

        if (expected != null && expected.equals(actual)) {
            return;
        }

        if (expected instanceof Double && actual instanceof Double
                || expected instanceof Float && actual instanceof Float) {
            double expectedDouble = (double) expected;
            double actualDouble = (double) actual;
            if (Math.abs(expectedDouble - actualDouble) < 1e-6) {
                return;
            }
        }

        if (expected instanceof Object[] && actual instanceof Object[]
                && Arrays.deepEquals((Object[]) expected, (Object[]) actual)) {
            return;
        }

        throw new AssertionError(String.format("%s\nExpected '%s' but got '%s'", message,
                expected.getClass().isArray() ? Arrays.deepToString((Object[]) expected) : expected,
                actual.getClass().isArray() ? Arrays.deepToString((Object[]) actual) : actual));
    }

    public static void assertInstanceOf(Object obj, Class<?> className, String message) {
        if (obj == null || !className.isInstance(obj)) {
            throw new AssertionError(String.format("%s\nExpected instance of '%s' but got '%s'",
                    message, className.getName(), obj == null ? "null" : obj.getClass().getName()));
        }
    }
}
