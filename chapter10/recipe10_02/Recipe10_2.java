package org.java17recipes.chapter10.recipe10_02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Recipe10_2 {
	Set<Thread> updateThreads = new HashSet<>();
	public static void main(String[] args) {
		Recipe10_2 recipe = new Recipe10_2();
		recipe.startProcess();
	}   

	private void startProcess() {
		ConcurrentMap<Integer,String> concurrentMap = new ConcurrentHashMap<>();
		for (int i =0;i < 1000;i++) {
			startUpdateThread(i, concurrentMap);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		concurrentMap.entrySet().stream().forEach((entry) -> {
			System.out.println("Key :"+entry.getKey()+" Value:"+entry.getValue());
		});

		updateThreads.stream().forEach((thread) -> {
			thread.interrupt();
		});
	}

	Random random = new Random();
	private void startUpdateThread(int i, final ConcurrentMap<Integer, String> concurrentMap) {
		Thread thread = new Thread(() -> {
			while (!Thread.interrupted()) {
				int randomInt = random.nextInt(20);
				concurrentMap.put(randomInt, UUID.randomUUID().toString());
			}
		});
		thread.setName("Update Thread "+i);
		updateThreads.add(thread);
		thread.start();
	}
}

