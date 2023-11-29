import java.util.ArrayList;

/**
 * @author avawandersleben
 */

public class Main {

    //Update this to change the number of tests to run.
    private static final int NUM_TESTS = 1000;

    private static LinkedList<Integer> nums = new LinkedList<>();
    private static ArrayList<Integer> nums1 = new ArrayList<>();
    private static boolean flag = true;

    public static void main(String[] args) {
        for (int i = 0; i < NUM_TESTS; i++) {
            String error = RandomTest();
            if(!flag) {
                System.out.println(error);
                throw new RuntimeException("Test failed");
            }
        }
        System.out.println("All tests passed :)");
    }

    public static String RandomTest() {
        int ran = (int)(Math.random() * 11);
        int index;
        String expected = "";
        String test = "";
        String result = "";
        switch(ran) {
            case 0:
                if (!(nums.size() == 0)) {
                    nums.remove();
                    nums1.remove(0);
                    test = "Remove no param";
                    expected = nums1.toString();
                    result = nums.toString();
                }
                break;
            case 1:
                index = (int)(Math.random() * nums.size()) + 1;
                if (nums.size() == 0) index = 0;
                int newNum2 = (int)(Math.random() * 10);
                nums.add(index, newNum2);
                nums1.add(index, newNum2);
                test = "Add with index";
                expected = nums1.toString();
                result = nums.toString();
                break;
            case 2:
                index = (int)(Math.random() * nums.size());
                int newNum = (int)(Math.random() * 10);
                if (!(nums.size() == 0)) {
                    nums.set(index, newNum);
                    nums1.set(index, newNum);
                    test = "Set with index";
                    expected = nums1.toString();
                    result = nums.toString();
                }
                break;
            case 3:
                index = (int)(Math.random() * nums.size());
                if (!(nums.size() == 0)) {
                    nums.remove(nums.get(index));
                    nums1.remove(nums1.get(index));
                    test = "Remove element";
                    expected = nums1.toString();
                    result = nums.toString();
                }
                break;
            case 4:
                if (nums.size() != 0) {
                    flag = (nums1.get(0) == nums.getHead().getData());
                    test = "Remove no param";
                    expected = Integer.toString(nums1.get(0));
                    result = Integer.toString(nums.getHead().getData());
                }
                break;
            case 5:
                int newNum3 = (int)(Math.random() * 10);
                nums.add(newNum3);
                nums1.add(newNum3);
                test = "Add with element";
                expected = nums1.toString();
                result = nums.toString();
                break;
            case 6:
                int newNum4 = (int)(Math.random() * 10);
                flag = (nums.contains(newNum4) == nums1.contains(newNum4));
                test = "Contains";
                expected = Boolean.toString(nums1.contains(newNum4));
                result = Boolean.toString(nums.contains(newNum4));
                break;
            case 7:
                nums.clear();
                nums1.clear();
                test = "Clear";
                expected = nums1.toString();
                result = nums.toString();
                break;
            case 8:
                flag = (nums.isEmpty() == nums1.isEmpty());
                test = "isEmpty";
                expected = Boolean.toString(nums1.isEmpty());
                result = Boolean.toString(nums.isEmpty());
                break;
            case 9:
                flag = (nums.size() == nums1.size());
                test = "Size";
                expected = Integer.toString(nums1.size());
                result = Integer.toString(nums.size());
                break;
            case 10:
                index = (int)(Math.random() * nums.size());
                if (!(nums.size() == 0)) {
                    nums.remove(index);
                    nums1.remove(index);
                    test = "Remove with index";
                    expected = nums1.toString();
                    result = nums.toString();
                }
                break;
            case 11:
                String s1 = "";
                String s2 = "";
                for (Integer i : nums) {
                    s1 += i;
                }

                for (Integer i : nums1) {
                    s2 += i;
                }

                flag = s1.equals(s2);
                test = "Iterator";
                expected = s2;
                result = s1;
        }

        Object[] numsArr = nums.toArray();
        Object[] nums1Arr = nums1.toArray();

        String s = "\nExpected... " + expected + "\n\nBut got... " + result + "\n\nWhen testing " + test;
        if(numsArr.length != nums1Arr.length) {
            flag = false;
            return s;
        }

        for(int i = 0; i < numsArr.length; i++) {
            if (numsArr[i] != nums1Arr[i]) {
                flag = false;
                return s;
            }
        }

        return s;
    }
}