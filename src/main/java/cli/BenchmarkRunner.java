package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    private static final int[] SIZES = {100, 1000, 10000, 100000};
    private static final String[] TYPES = {"random", "sorted", "reverse", "nearly-sorted"};

    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        PerformanceTracker tracker = new PerformanceTracker();

        try (FileWriter writer = new FileWriter("benchmark-results.csv")) {
            writer.write("size,type,comparisons,swaps,time_ms\n");

            for (int n : SIZES) {
                for (String type : TYPES) {
                    int[] arr = generateArray(n, type);

                    sorter.resetMetrics();
                    tracker.startTimer();
                    sorter.sort(arr.clone());
                    tracker.stopTimer();

                    writer.write(String.format("%d,%s,%d,%d,%.2f\n",
                            n, type,
                            sorter.getComparisons(),
                            sorter.getSwaps(),
                            tracker.getElapsedTimeMs()));
                }
            }
            System.out.println("Benchmark completed. Results in: benchmark-results.csv");
        } catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }

    private static int[] generateArray(int n, String type) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }

        switch (type) {
            case "sorted":
                Arrays.sort(arr);
                break;
            case "reverse":
                Arrays.sort(arr);
                for (int i = 0; i < n / 2; i++) {
                    int t = arr[i];
                    arr[i] = arr[n - 1 - i];
                    arr[n - 1 - i] = t;
                }
                break;
            case "nearly-sorted":
                Arrays.sort(arr);
                for (int i = 0; i < n * 0.05; i++) {
                    int a = rand.nextInt(n), b = rand.nextInt(n);
                    int t = arr[a]; arr[a] = arr[b]; arr[b] = t;
                }
                break;
        }
        return arr;
    }
}