public class GroceryShopping {
	public static void main(String[] args) {
		float bananaCost = 3.99f;
		float applesCost = 1.25f;
		int numApples = 4;
		float couponValue = 0.53f;
		float taxRate = 0.08f;
		float orderTotal = 0.0f;

		orderTotal += (bananaCost / 2);
		orderTotal += (applesCost * numApples);
		orderTotal -= (couponValue * 3);
		orderTotal *= (1 + taxRate);

		float orderTotalTrunc = (((int)(orderTotal * 100)) / 100f);

		System.out.println("Your order total is $" + orderTotalTrunc + ".");

		int dollars = 10;
		dollars -= orderTotalTrunc;

		System.out.println("You have " + dollars + " dollar bills remaining.");
	}

}