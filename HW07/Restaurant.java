/**
 * Class that represents a restaurant and the sushi orders that will be taken in.
 * @author Hyeokjin Jin
 * @version CS1331 HW07
 */

public class Restaurant {

    /**
     * Sorts the sushi rolls in ascending lexicographical by name.
     * @param sushiArray Array of sushiRolls that will be sorted
     * @return sushiRoll array that is sorted
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] sushiArray) {
        if (sushiArray.length == 0) {
            return new SushiRoll[0];
        }

        SushiRoll[] firstHalf = RecursionUtils.copyOfRange(sushiArray, 0, sushiArray.length / 2);
        if (firstHalf.length != 1) {
            firstHalf = mergeSortRolls(firstHalf);
        }
        SushiRoll[] secondHalf = RecursionUtils.copyOfRange(sushiArray, sushiArray.length / 2, sushiArray.length);
        if (secondHalf.length != 1) {
            secondHalf = mergeSortRolls(secondHalf);
        }
        return RecursionUtils.merge(firstHalf, secondHalf);
    }


    /**
     * Method that merges and sorts multiple SushiRoll orders into one order.
     * @param orderArray An array of SushiRoll arrays
     * @return A sorted array containing SushiRoll objects from multiple sushi orders
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orderArray) {
        if (orderArray.length == 0) {
            return new SushiRoll[0];
        }
        return mergeOrdersHelper(orderArray.length - 1, orderArray);
    }

    /**
     * Helper method for mergeOrders method.
     * @param index Current index of the orderArray
     * @param orderArray Inputted array with multiple sushi roll orders
     * @return A sorted array containing SushiRoll objects from multiple sushi orders
     */
    private static SushiRoll[] mergeOrdersHelper(int index, SushiRoll[][] orderArray) {
        if (index > 0) {
            return RecursionUtils.merge(orderArray[index], mergeOrdersHelper(index - 1, orderArray));
        } else {
            return orderArray[0];
        }
    }


    /**
     * Method that finds all sushi rolls on plates of a specified color.
     * @param sushiArray A sorted array of SushiRoll objects that will be searched through
     * @param plateColor Specified sushi roll plate color that will be searched for
     * @return SushiRoll array with all rolls on plates of the desired color
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] sushiArray, Color plateColor) {
        if (sushiArray.length == 0) {
            return new SushiRoll[0];
        }
        return platesOfColorHelper(sushiArray.length - 1, plateColor, sushiArray);
    }

    /**
     * Helper method to find all sushi rolls on plates of a desired color.
     * @param index Current index of inputArray
     * @param plateColor Specified sushi roll plate color that will be searched for
     * @param inputArray A sorted array of SushiRoll objects that will be searched through
     * @return SushiRoll array with all rolls on plates of the desired color
     */
    private static SushiRoll[] platesOfColorHelper(int index, Color plateColor, SushiRoll[] inputArray) {
        if (index > 0) {
            if (inputArray[index].getColor().equals(plateColor)) {
                return RecursionUtils.merge(
                        new SushiRoll[]{inputArray[index]}, platesOfColorHelper(index - 1, plateColor, inputArray));
            } else {
                return RecursionUtils.merge(
                        new SushiRoll[0], platesOfColorHelper(index - 1, plateColor, inputArray));
            }
        } else {
            if (inputArray[index].getColor().equals(plateColor)) {
                return new SushiRoll[]{inputArray[index]};
            } else {
                return new SushiRoll[0];
            }
        }
    }


    /**
     * Method that recursively loops through the inputted array of
     * SushiRoll objects and finds the total price of the order.
     * @param sushiArray Inputted array of SushiRoll objects
     * @return The total price of the sushi order
     */
    public static double totalPrice(SushiRoll[] sushiArray) {
        if (sushiArray.length == 0) {
            return 0.0;
        }
        return totalPriceHelper(sushiArray.length - 1, sushiArray);
    }

    /**
     * Helper method for totalPrice method.
     * @param index Current index of the sushiArray
     * @param sushiArray Inputted array of SushiRoll objects
     * @return The total price of the sushi order
     */
    private static double totalPriceHelper(int index, SushiRoll[] sushiArray) {
        if (index > 0) {
            return (sushiArray[index].getColor().getPrice() + totalPriceHelper(index - 1, sushiArray));
        } else {
            return (sushiArray[index].getColor().getPrice());
        }
    }


    /**
     * Method that takes in a sorted array of SushiRoll objects and flips it to
     * become a sorted list in descending lexicographical order.
     * @param sushiArray Inputted sorted array of SushiRoll objects
     */
    public static void flip(SushiRoll[] sushiArray) {
        flipHelper(sushiArray, 0, sushiArray.length - 1);
    }

    /**
     * Helper method for flip method.
     * @param sushiArray Inputted array of SushiRoll objects
     * @param start Starting index
     * @param end End index
     */
    private static void flipHelper(SushiRoll[] sushiArray, int start, int end) {
        if (start < end) {
            SushiRoll temp = sushiArray[start];
            sushiArray[start] = sushiArray[end];
            sushiArray[end] = temp;

            flipHelper(sushiArray, start + 1, end - 1);
        }
    }
}
