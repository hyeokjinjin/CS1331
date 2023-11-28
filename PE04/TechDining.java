import java.util.Random;

public class TechDining {
    public static Food[] createMeal(int length) {
        Random rand = new Random();
        Food[] meal = new Food[length];
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(6);
            meal[i] = Food.values()[index];
        }
        return meal;
    }

    public static Food[][] createOrder(int number) {
        Food[][] order = new Food[number][];
        for (int i = 0; i < number; i++) {
            order[i] = createMeal(number - i);
        }
        return order;
    }

    public static int mealCost(Food[] meal) {
        int cost = 0;
        for (Food item : meal) {
            cost += item.ordinal();
        }
        return cost;
    }

    public static int orderCost(Food[][] order) {
        int cost = 0;
        for (Food[] meal : order) {
            cost += mealCost(meal);
        }
        return cost;
    }

}
