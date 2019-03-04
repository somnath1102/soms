package com.somnath;

import java.util.Random;

public class Montyhall {

	public static void main(String[] args) {
		Random random = new Random();
		long stayWins = 0;
		double sampleSize = Math.pow(10, 6);
		//double sampleSize = 44444;
		for (long i = 0; i < sampleSize; i++) {
			
			// set the prize - monty
			int prize = random.nextInt(3);
			
			// choice - user
			int choice = random.nextInt(3);

			if (prize == choice)
				stayWins++;
		}
		
		System.out.println("Stay Wins %age  " + Math.floor(stayWins/sampleSize * 100));
	}

}
