import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {

	private static double rounder(double numIn) {
		return Math.round(numIn * 100.0) / 100.0;
	}

	public static void main(String[] args) {

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		String myPoke;
		String rivalPoke;

		double rivalHealth = rounder((rand.nextInt(20) + 40));

		System.out.print("Enter your Pokemon's nickname: ");
		myPoke = scan.nextLine().trim();

		System.out.print("Enter your rival Pokemon's nickname: ");
		rivalPoke = scan.nextLine().trim();

		System.out.printf("Your rival has chosen %s to fight, which has %.2f health.%n", rivalPoke, rivalHealth);

		int turns = 0;
		do {
			AttackType attack = AttackType.values()[rand.nextInt(3)];

			double totalDamage = 0;
			if (attack == AttackType.SCRATCH) {
				int scratchTurns = rand.nextInt(3) + 1;
				double scratchDamage = rounder((rand.nextDouble() * 5) + 1);
				totalDamage = scratchTurns * scratchDamage;
			}
			else if (attack == AttackType.SURF) {
				totalDamage = rounder((rand.nextDouble() * 9) + 2);
			}
			else if (attack == AttackType.TACKLE) {
				totalDamage = rounder((rand.nextDouble() * 2) + 7);
			}

			rivalHealth -= totalDamage;
			System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.%n", myPoke, attack, totalDamage, Math.max(rivalHealth, 0));
			turns++;
		}
		while (rivalHealth > 0);

		System.out.printf("%s fainted after %d turns!%n", rivalPoke, turns);
		double money = (rand.nextDouble() * -1200) + 2400;
		System.out.printf("You have earned $%.2f!%n", money);
		scan.close();
	}
}