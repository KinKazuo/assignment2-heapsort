package algorithms;

public class HeapSort {
    private long comparisons = 0;
    private long swaps = 0;

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            swaps++;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize) {
            comparisons++;
            if (arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }
        }

        if (rightChild < heapSize) {
            comparisons++;
            if (arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }
        }

        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            swaps++;
            heapify(arr, heapSize, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public void resetMetrics() { comparisons = 0; swaps = 0; }
}