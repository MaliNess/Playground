import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CandyRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Random r = new Random();

		int choise;
		do {
			System.out.print("Enter 0, if you wanna get random data, or 1, if you wanna input data yourself: ");
			choise = in.nextInt();
		} while (choise != 0 && choise != 1);

		int numRobots;
		int maxCost;

		if (choise == 0) {
			numRobots = r.nextInt(9999) + 1;
		} else {
			System.out.print("Enter number of robots:");
			numRobots = in.nextInt();
		}
		int[][] roboStats = new int[numRobots][3];

		if (choise == 0) {
			maxCost = r.nextInt(9999) + 1;
			for (int i = 0; i < roboStats.length; i++) {
				// конфет в час
				roboStats[i][0] = r.nextInt(9999) + 1;
				// стандартых часов
				roboStats[i][1] = r.nextInt(9999) + 1;
				// зарплата за час
				roboStats[i][2] = r.nextInt(9999) + 1;
			}
			System.out.println();
		} else {
			System.out.print("Enter the maximum cost:");
			maxCost = in.nextInt();
			System.out.println();

			for (int i = 0; i < roboStats.length; i++) {
				// конфет в час
				System.out.print("Input robot#" + (i + 1) + "'s performance: ");
				roboStats[i][0] = in.nextInt();
				// стандартых часов
				System.out.print("Input robot#" + (i + 1) + "'s endurance: ");
				roboStats[i][1] = in.nextInt();
				// зарплата за час
				System.out.print("Input robot#" + (i + 1) + "'s cost: ");
				roboStats[i][2] = in.nextInt();
				System.out.println();
			}
		}

		System.out.println("Input complited!");
		System.out.println();

		int cost = 0;
		int candies = 0;
		int pres;

		double[] moneyPerCandy = new double[numRobots];
		for (int i = 0; i < moneyPerCandy.length; i++) {
			moneyPerCandy[i] = (float) roboStats[i][2] / roboStats[i][0];
		}

		while (cost < maxCost) {
			pres = findMin(moneyPerCandy);
			for (int i = 0; i < roboStats[pres][1]; i++) {
				if (cost + roboStats[pres][2] > maxCost) {
					moneyPerCandy[pres] = Double.MAX_VALUE;
					break;
				}
				candies += roboStats[pres][0];
				cost += roboStats[pres][2];
			}
			if (moneyPerCandy[pres] != Double.MAX_VALUE)
				moneyPerCandy[pres] = roboStats[pres][2];
			if (checkMPC(moneyPerCandy))
				break;
		}

		System.out.println("You got " + candies + " candies!");
		System.out.println("You spent " + cost + "$.");
		System.out.println((maxCost - cost) + "$ left.");

		in.close();
	}

	private static int findMin(double[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == Arrays.stream(ar).min().getAsDouble())
				return i;
		}
		return -1;
	}

	private static boolean checkMPC(double[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != Double.MAX_VALUE)
				return false;
		}
		return true;
	}

}
