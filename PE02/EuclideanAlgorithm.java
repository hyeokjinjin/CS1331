public class EuclideanAlgorithm {
	public static void main(String[] args) {

		//Declaring all required variables
		int num1 = 7;
		int num2 = 13;
		int steps = 0;
		int dividend = num1;
		int divisor = num2;
		int gcd;
		int quotient;
		int remainder;

		//Printf statement
		System.out.printf("Finding the greatest common divisor of %d and %d\n", num1, num2);

		//if-else statement
		if (divisor > dividend) {
			System.out.println("The inputs would have caused an unnecessary step.");
			divisor = num1;
			dividend = num2;
		}
		else {
			System.out.println("An extra step was avoided");
		}

		//do-while loop
		do {
			steps++;
			quotient = (dividend / divisor);
			remainder = (dividend % divisor);
			System.out.printf("Step %d: %d = %d * %d + %d\n", steps, dividend, divisor, quotient, remainder);
			gcd = divisor;
			dividend = divisor;
			divisor = remainder;
		}
		while (remainder != 0);

		//println statement
		System.out.println("The GCD is "+ gcd + ".");

		//switch statement
		switch (steps) {
		case 1:
			System.out.println("Only one step was needed!");
			break;
		case 2:
			System.out.println("Two steps were taken!");
			break;
		case 3:
			System.out.println("This process took three steps.");
			break;
		case 4:
			System.out.println("Wow! Four steps.");
			break;
		default:
			System.out.println(steps + " steps is a lot of steps!");
		}

		System.out.printf(gcd != 1 ? "%d and %d are not relatively prime\n" : "%d and %d are relatively prime.\n", num1, num2); 
	}

}