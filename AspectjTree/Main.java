//package gr.dit.hw1.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static Tree tree = new Tree();

    public static void main(String[] args) {
        List<Thread> allThreads = new ArrayList<>();

        createInsertThreads(allThreads, 5, 100000, 10000);

        createDeleteThreads(allThreads, 3, 100000, 1000);

        createLookUpThreads(allThreads, 9, 100000, 1000);

        for (Thread thread : allThreads) {
            thread.start();
        }
        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            	System.err.println(e);
            }
        }
    }

	private static void createInsertThreads(List<Thread> allThreads, int numberOfInsertThreads, int insertForEveryThread, int upperBound) {
		for (int i = 0; i < numberOfInsertThreads; i++) {
            allThreads.add(new Thread(() -> {
                Random rand = new Random();
                for (int j = 0; j < insertForEveryThread; j++) {
                    tree.insert(rand.nextInt(upperBound));
                }
            }));
        }
	}
	
	private static void createDeleteThreads(List<Thread> allThreads, int numberOfDeleteThreads, int deleteForEveryThread, int upperBound) {
		for (int i = 0; i < numberOfDeleteThreads; i++) {
            allThreads.add(new Thread(() -> {
                Random rand = new Random();
                for (int j = 0; j < deleteForEveryThread; j++) {
                    tree.deleteKey(rand.nextInt(upperBound));
                }
            }));
        }
	}
	
	private static void createLookUpThreads(List<Thread> allThreads,  int numberOfLookUpThreads, int lookUpForEveryThread, int upperBound) {
		for (int i = 0; i < numberOfLookUpThreads; i++) {
            allThreads.add(new Thread(() -> {
                Random rand = new Random();
                for (int j = 0; j < lookUpForEveryThread; j++) {
                    tree.search(rand.nextInt(upperBound));
                }
            }));
        }
	}

}
