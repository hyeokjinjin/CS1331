public class Speedometer {
	/**
	 * Name: Hyeokjin Jin
	 * Fun Fact: I love playing the bass guitar
	 **/

	public static void main(String[] args) {
		int kilometers = 50;
		float kmPerMile = 1.60934f;
		float hours = 0.54f;
		String name = "Hyeokjin Jin";

		float miles = kilometers / kmPerMile;
		float milesTrunc = (((int)(miles * 1000)) / 1000f);
		float speed = (((int)(milesTrunc / hours * 100)) / 100f);


		System.out.println(name + " drove at a speed of " + speed + " mph for " + milesTrunc + " miles!");
	}
}