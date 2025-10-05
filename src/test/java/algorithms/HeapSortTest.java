package algorithms;

import junit.framework.TestCase;

public class HeapSortTest extends TestCase {
    private final HeapSort sorter = new HeapSort();

    public void testEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertEquals(0, arr.length);
    }

    public void testSingleElement() {
        int[] arr = {42};
        sorter.sort(arr);
        assertEquals(42, arr[0]);
    }

    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i + 1, arr[i]);
        }
    }

    public void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i + 1, arr[i]);
        }
    }

    public void testDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        sorter.sort(arr);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6, 9};
        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }

    public void testNegativeNumbers() {
        int[] arr = {-1, 3, -5, 2, 0};
        sorter.sort(arr);
        int[] expected = {-5, -1, 0, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
    }
}