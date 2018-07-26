
/*
 	SoloLearn problem Candy Robots
 	
 		Robots producing candies in a candy factory have the following integer attributes:
 			-Performance (P)
 			-Endurance (E)
 			-Cost (C)
 			
 		A robot can produce P candies per hour for E consecutive hours.
 		After E hours, the robot will be able to produce only 1 candy per hour.
 		The operation cost of a robot is C dollars per hour.
 		
 		Create a program that takes the following inputs and produces the corresponding output, 
 		optimizing the efficiency of the robots:
 		Input
 			-number of robots
 			-maximum cost you can afford
 			-P, E, C for each robot (number-of-robots times)
 		Output
 			-The maximum possible number of candies that can be produced with the given robots
 			and the given maximum affordable cost. 	
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CandyRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Random r = new Random();

		int choise; // auto or manual input;
		do {
			System.out.print("Enter 0, if you wanna get random data, or 1, if you wanna input data yourself: ");
			choise = in.nextInt();
		} while (choise != 0 && choise != 1);

		int numRobots; // number of robots;
		int maxCost; // maximum affordable cost;

		if (choise == 0) { // random input;
			numRobots = r.nextInt(99) + 1;
			System.out.print("Number of robots: " + numRobots);
			System.out.println();
			maxCost = r.nextInt(9999) + 1; // maximum cost
			System.out.print("Maximum cost: " + maxCost);
			System.out.println();
		} else { // manual input;
			System.out.print("Enter number of robots:");
			numRobots = in.nextInt();
			System.out.print("Enter the maximum cost:"); // maximum cost;
			maxCost = in.nextInt();
			System.out.println();
		}
		int[][] roboStats = new int[numRobots][3]; // array of robots P, E, C:
													// each column contains P, E, C of one robot;
		System.out.print("If you wanna see created robots input 1, else - 0: ");
		int choise1 = in.nextInt();
		if (choise == 0) { // random input
			System.out.println();
			for (int i = 0; i < roboStats.length; i++) {
				// candies per hour (P)
				roboStats[i][0] = r.nextInt(99) + 1;
				// consecutive hours (E)
				roboStats[i][1] = r.nextInt(99) + 1;
				// cost (C)
				roboStats[i][2] = r.nextInt(99) + 1;
				if(choise1==1) System.out.println("Robot #" + (i + 1) + " P=" + roboStats[i][0] + " E=" + roboStats[i][1] + " C="
						+ roboStats[i][2]);
			}
			System.out.println();
		} else { // manual input
			for (int i = 0; i < roboStats.length; i++) {
				// candies per hour (P)
				System.out.print("Input robot#" + (i + 1) + "'s performance: ");
				roboStats[i][0] = in.nextInt();
				// consecutive hours (E)
				System.out.print("Input robot#" + (i + 1) + "'s endurance: ");
				roboStats[i][1] = in.nextInt();
				// cost (C)
				System.out.print("Input robot#" + (i + 1) + "'s cost: ");
				roboStats[i][2] = in.nextInt();
				System.out.println();
			}
		}

		System.out.println("Input complited!");
		System.out.println();

		int cost = 0; // present cost;
		int candies = 0; // present amount of candies;
		int pres; // present operating robot;

		int[][] stats = new int[numRobots][2]; // worked hours and produced candies
		double[] moneyPerCandy = new double[numRobots]; // price of 1 candy for each robot:
														// price per hour/candies per hour;
		for (int i = 0; i < moneyPerCandy.length; i++) {
			moneyPerCandy[i] = (float) roboStats[i][2] / roboStats[i][0];
		}

		while ((cost < maxCost) && !checkMPC(moneyPerCandy)) {
			pres = findMin(moneyPerCandy); // choosing robot with the lowest price per 1 candy;
			for (int i = 0; i < roboStats[pres][1]; i++) { // robot produces candies for all its
															// consecutive hours;
				if (cost + roboStats[pres][2] > maxCost) { // if robot still has consecutive hours left,
															// but the price is too high to produce
															// more candies, its price per 1 candy
															// changes to max value existing,
															// so it won't operate again and
					moneyPerCandy[pres] = Double.MAX_VALUE;
					break; // the loop for this robot ends;
				}
				candies += roboStats[pres][0]; // if the cost still fits the maximum cost,
												// the robot operates one more hour and produces candies
				stats[pres][1] += roboStats[pres][0]; // statistic of robot (produced candies)
				cost += roboStats[pres][2]; // the cost of operated hour adds to the whole cost;
				stats[pres][0] += 1; // statistic of robot (worked hours)
			}
			if (moneyPerCandy[pres] != Double.MAX_VALUE) // if robot's cost still fits the maximum cost,
															// but it has already operated its consecutive
															// hours, it's performance changes to 1 candy
															// per hour, so the cost of 1 candy will be
															// equal to the cost of the robot;
				moneyPerCandy[pres] = roboStats[pres][2];
		}

		System.out.println("You got " + candies + " candies!"); // result: amount of candies;
		System.out.println();

		System.out.print("Wanna see money statistics? Print 1 for 'yes' or 0 for 'no': ");
		if (in.nextInt() == 1) {
			System.out.println("You spent " + cost + "$."); // additional result: final price;
			System.out.println((maxCost - cost) + "$ left."); // additional result: money left;
		}
		System.out.println();
		System.out.print("Wanna see robots' statistics? Print 1 for 'yes' or 0 for 'no': ");
		if (in.nextInt() == 1) {
			for (int i = 0; i < numRobots; i++) {
				if (stats[i][0] != 0)
					System.out.println("Robot #" + (i + 1) + " worked " + stats[i][0] + " hours and produced "
							+ stats[i][1] + " candies.");
			}
		}

		in.close();
	}

	private static int findMin(double[] ar) { // finds the less price per 1 candy
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == Arrays.stream(ar).min().getAsDouble())
				return i;
		}
		return -1;
	}

	private static boolean checkMPC(double[] ar) { // checks if there is a robot,
													// which price still fits the maximum cost
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != Double.MAX_VALUE)
				return false;
		}
		return true;
	}

}
