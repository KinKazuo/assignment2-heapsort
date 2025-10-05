package metrics;

public class PerformanceTracker {
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public double getElapsedTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }
}