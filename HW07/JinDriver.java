import java.util.Arrays;

public class JinDriver {

    public static void main(String[] args) {

        // Creating SushiRoll Objects
        SushiRoll tobiko = new SushiRoll("Tobiko", Color.GREEN);
        SushiRoll avocado = new SushiRoll("Avocado", Color.BLUE);
        SushiRoll unagi = new SushiRoll("Unagi", Color.RED);
        SushiRoll dragon = new SushiRoll("Dragon", Color.BLUE);
        SushiRoll maki = new SushiRoll("Maki", Color.RED);

//        // Sorting SushiRoll Objects in Array
//        SushiRoll[] array = new SushiRoll[]{tobiko, avocado, unagi, dragon, maki};
//        SushiRoll[] sortedArray = Restaurant.mergeSortRolls(array);
//        System.out.println("Test: mergeSortRolls");
//        System.out.println(Arrays.toString(Restaurant.mergeSortRolls(new SushiRoll[0])));
//        System.out.println(Arrays.toString(sortedArray));
//        System.out.println();
//
//
//        // Merging SushiRoll orders and sorting
//        SushiRoll[] ad = new SushiRoll[]{avocado, dragon};
//        SushiRoll[] tu = new SushiRoll[]{tobiko, unagi};
//        SushiRoll[] m = new SushiRoll[]{maki};
//        SushiRoll[][] testArray = new SushiRoll[][]{ad, tu, m};
//        System.out.println("Test: mergeOrders");
//        System.out.println(Arrays.toString(Restaurant.mergeOrders(new SushiRoll[0][])));
//        System.out.println(Arrays.toString(testArray));
//        System.out.println(Arrays.toString(Restaurant.mergeOrders(testArray)));
//        System.out.println();


        // Finding order with preferred plate color
        SushiRoll[] plateColor = new SushiRoll[]{avocado, dragon, maki, tobiko, unagi};
        System.out.println("Test: plateOfColor");
        System.out.println(Arrays.toString(Restaurant.platesOfColor(plateColor, Color.BLUE)));
        System.out.println();


//        // Finding price of sushi order
//        SushiRoll[] priceArray = new SushiRoll[]{avocado, dragon, maki, tobiko, unagi};
//        System.out.println("Test: totalPrice");
//        System.out.println(Arrays.toString(priceArray));
//        System.out.println(Restaurant.totalPrice(new SushiRoll[0]));
//        System.out.println(Restaurant.totalPrice(priceArray));
//        System.out.println();
//
//
//        // Flipping sushi order
//        Restaurant.flip(sortedArray);
//        System.out.println("Test: flip");
//        System.out.println(Arrays.toString(sortedArray));
//        System.out.println();
    }
}
