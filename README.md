Assignment 2 - Heap Sort
Author: KinKazuo SE-2436
Partner: Yevgeniy Averyanov (Shell Sort)
Pair: 2 — Advanced Sorting Algorithms
Usage
1. Build the project
   mvn clean package
2. Run CLI
   java -jar target/assignment2-heapsort-1.0.jar
3. Example:
   java -jar target/assignment2-heapsort-1.0.jar 10000

The program will run benchmarks on arrays of sizes: 100, 1000, 10000, and 100000, across four input types:

random
sorted
reverse
nearly-sorted

3. Results
Performance metrics are saved in benchmark-results.csv.

Each row contains:

size: Input array size
type: Data distribution type
comparisons: Number of key comparisons
swaps: Number of element swaps
time_ms: Execution time in milliseconds
This data enables empirical analysis and complexity verification.

Complexity Analysis
Worst-case:
O(n log n) — guaranteed for all inputs.

Unlike Shell Sort, Heap Sort does not degrade on adversarial inputs. The worst case occurs even on random data due to full heap construction and extraction phases.

Average-case:
O(n log n) — consistent performance regardless of input distribution.

No probabilistic optimizations reduce runtime; every input undergoes Θ(n log n) operations.

Best-case:
O(n log n) — even when the array is already sorted.

There is no early termination possible because:

Building the max-heap takes Θ(n)
Extracting all elements takes Θ(n log n)
Chart 1: Time vs n
<img width="603" height="360" alt="EXCEL_PHopx4QSXN" src="https://github.com/user-attachments/assets/c51c8c33-6012-4503-b761-79d29573144d" />

Execution time (ms) vs input size (n) for different data distributions.
Key Observations:
All curves follow approximately nlogn growth.
On large inputs (n = 100,000):
Sorted: 8.27 ms
Reverse: 8.47 ms
Nearly-sorted: 9.49 ms
Random: 14.27 ms
Surprisingly, random data is nearly twice as slow as sorted/reverse despite same asymptotic complexity.
Explanation:
Memory access patterns: Sorted/reverse arrays have better cache locality during heapify.
Branch prediction: CPU predicts comparisons more accurately on structured data.
Swaps and comparisons: Slightly fewer operations on ordered inputs due to reduced heap violations.
Despite theoretical uniformity, practical performance varies significantly based on input characteristics.

Conclusion
Heap Sort was implemented as an in-place algorithm using bottom-up heapify, ensuring optimal heap construction in O(n) time.

It guarantees O(n log n) time complexity in all cases — making it one of the few sorting algorithms with bounded worst-case behavior.

While it does not benefit from partially sorted data like Shell Sort, its predictability makes it suitable for real-time systems where performance must be deterministic.

Metrics and benchmarks confirmed theoretical complexity with real-world data across multiple input distributions.

Edge cases (empty, single-element, duplicates) were handled correctly, ensuring robustness.

This work demonstrates how theoretical guarantees can be validated empirically — a critical skill in algorithm engineering.

The implementation provides detailed performance tracking, enabling transparent analysis and peer review.
Author
Abilkhaiyr Sarsenbay
SE-2436
