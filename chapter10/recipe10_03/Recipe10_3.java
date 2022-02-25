package org.java17recipes.chapter10.recipe10_03;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Recipe10_3 {

	Set<Thread> updateThreads = new HashSet<>();
	Random random = new Random();

	public static void main(String[] args) {
		Recipe10_3 recipe = new Recipe10_3();
		recipe.startProcess();
	}

	private void startProcess() {
		ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			startUpdateThread(i, concurrentMap);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		concurrentMap.entrySet().stream().forEach((entry) -> {
			System.out.println("Key :" + entry.getKey() + " Value:" + entry.getValue());
		});

	}



	private void startUpdateThread(final int i, final ConcurrentMap<Integer, String> concurrentMap) {
		Thread thread = new Thread(() -> {
			int randomInt = random.nextInt(20);
			String previousEntry = concurrentMap.putIfAbsent(randomInt, "Thread # " + i + " has made it!");
			if (previousEntry != null) {
				System.out.println("Thread # " + i + " tried to update it but guess what, we're too late!");
			} else {
				System.out.println("Thread # " + i + " has made it!");  
			}
		});
		thread.start();
	}

}

