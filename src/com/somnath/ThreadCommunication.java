package com.somnath;

/**
 * Avoid spinlocks - ie do not check for flag before taking a lock - code will be looping unecessarily
 * without doing anything useful - always better to take lock - check for condition and then go to wait state if condition is not met.
 * SPin lock is also known as BUSY_WAITING
 * @author mukherj9
 *
 */
public class ThreadCommunication {

	// make volatile race condition safe only if written by a single thread
	static volatile boolean printRed = true;
	static Object sharedLock = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				int count = 0;
				while (count < 100) {
					//System.out.println("Thread in while loop " + Thread.currentThread().getName());
					synchronized (sharedLock) {
						//System.out.println("got lock in " + Thread.currentThread().getName());
						// needed for spurious wakeups
						while (!printRed) {
							try {
								//System.out.println("waiting started by " + Thread.currentThread().getName());
								sharedLock.wait();
								//System.out.println("waiting over in " + Thread.currentThread().getName());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("REDDDD printed by " + Thread.currentThread().getName());
						count++;
						printRed = false;
						sharedLock.notifyAll();
						//System.out.println("notifying from " + Thread.currentThread().getName());
					}

				}

			};
		};

		Thread t2 = new Thread() {
			public void run() {
				int count = 0;
				while (count < 100) {
					//System.out.println("Thread in while loop " + Thread.currentThread().getName());
					synchronized (sharedLock) {
						///System.out.println("got lock in " + Thread.currentThread().getName());
						while (printRed) {
							try {
							//System.out.println("waiting started by " + Thread.currentThread().getName());
								sharedLock.wait();
								//System.out.println("waiting over in " + Thread.currentThread().getName());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("BLUUUUUU printed by " + Thread.currentThread().getName());
						count++;
						printRed = true;
						sharedLock.notifyAll();
						//System.out.println("notifying from " + Thread.currentThread().getName());
					}
				}
				;
			};
		};

		t1.start();
		t2.start();
	}
}
