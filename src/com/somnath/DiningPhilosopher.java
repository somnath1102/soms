package com.somnath;

import java.util.Random;

public class DiningPhilosopher {
	volatile static boolean stopped = false;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i < 6; i++) {
			if (i == 5)
				new Thread(new Philosopher(1, i, i + " - Philosopher")).start();
			else
				new Thread(new Philosopher(i, i + 1, i + " - Philosopher")).start();
		}
		Thread.sleep(30 * 1000);
		stopped = true;
		System.out.println("Main has stopped");
	}

}

class Philosopher implements Runnable {
	final private Integer small;
	final private Integer big;
	final private String name;

	public Philosopher(Integer small, Integer big, String name) {
		this.small = small;
		this.big = big;
		this.name = name;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (!DiningPhilosopher.stopped) {
			// hungry again
			synchronized (small) {
				synchronized (big) {
					// eating - got both the forks
					System.out.println(name + " is eating");
					try {
						Thread.sleep(1000 + random.nextInt(2000));
					} catch (InterruptedException e) {
					}
				}
			}
			try {
				// thinking
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}

	}
}
