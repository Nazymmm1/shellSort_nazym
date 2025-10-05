package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = 10000;
        int[] inputSizes={100,1000,10000,100000};

        for (int inputSize: inputSizes){
            System.out.println("The array size= "+ inputSize);

            int[] arr = new Random().ints(n, 0, 100000).toArray();

            for (ShellSort.GapSequence seq : ShellSort.GapSequence.values()) {
                int[] copy = arr.clone();
                PerformanceTracker tracker = new PerformanceTracker();
                ShellSort.sort(copy, tracker, seq);
                System.out.printf("%s: Comparisons=%d, Swaps=%d, Time=%.2f ms%n",
                        seq, tracker.getComparisons(), tracker.getSwaps(), tracker.getElapsedTime());
            }
            System.out.println();
        }



    }
}