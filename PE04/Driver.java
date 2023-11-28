public class Driver {
    public static void main(String[] args) {
        Food[] firstMeal = TechDining.createMeal(6);
        Food[] secondMeal = TechDining.createMeal(3);
        System.out.println("First Meal:");
        for (Food item : firstMeal) {
            System.out.println(item);
        }
        System.out.println("First order cost: " + TechDining.mealCost(firstMeal));
        System.out.println();

        System.out.println("Second Meal:");
        for (Food item : secondMeal) {
            System.out.println(item);
        }
        System.out.println("Second order cost: " + TechDining.mealCost(secondMeal));
        System.out.println();

        Food[][] firstOrder = TechDining.createOrder(6);
        Food[][] secondOrder = TechDining.createOrder(3);
        System.out.println("First Order:");
        for (Food[] order : firstOrder) {
            for (Food meal : order) {
                System.out.println(meal);
            }
            System.out.println();
        }
        System.out.println("First order cost: " + TechDining.orderCost(firstOrder));
        System.out.println();

        System.out.println("Second Order:");
        for (Food[] order : secondOrder) {
            for (Food meal : order) {
                System.out.println(meal);
            }
            System.out.println();
        }
        System.out.println("Second order cost: " + TechDining.orderCost(secondOrder));
        System.out.println();
    }
}
