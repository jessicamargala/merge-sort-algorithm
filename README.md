# Merge Sort Algorithm

Implementation of **MergeSort algorithm**.
Using the Divide and Conquer approach, Merge Sort creates a nondecreasing list of n sorted integers, by recursively dividing the list into 2 sub-arrays of n/2 integers, then solving each sub-array by recursively sorting it, and finally, combining the solutions to the sub-arrays by merging them into one single sorted array S. Also, by not using an in-place sort method for the mergesort implementation, temporary arrays U and V are needed, using extra space.

# Quick Sort Algorithm

Implementation of **QuickSort algorithm**.
Similarly, Quick Sort also makes use of the Divide and Conquer approach to sort through a list of n integers. However, they are not quite the same. In Quick Sort, a pivot item is used to partition (divide) the list into two sub-arrays, with one sub-array filled with integers smaller than the pivot item, and the other sub-array filled with integers larger than the pivot item. The pivot item can be any item. In my case, it is the last item in the list. Quick Sort calls itself recursively, updating the pivot item and sorting each sub-array, until only a one integer sub-list is obtained.

# Time Complexities

* MergeSort<br>
The array is repeatedly being divided into two equally sized parts. However, if the number of elements n is doubled, there is only one additional division required. Therefore, the number of divisions can be calculated by _log(base 2)n_. Additionally, for each merge step, we merge n integers. Since there are no nested loops in the implementation, we can expect it to operate with linear complexity, meaning that if n is doubled, the time to merge would double as well. Ultimately, n integers multiplied by _log(base 2)n_ division/merge steps, gives us a Time Complexity of **O(nlgn)**.
* Quick Sort<br>
In both the best and average cases, the time complexity is expected to be very similar to Merge Sort’s and for similar reasons. The arrays and subarrays are always divided into two partitions of equal size. If the number of elements is doubled, then one additional division is required. Meaning that partitioning has a time complexity of _log(base 2)n_. Additionally, each partition step requires a division of n numbers. This is done with linear complexity, O(n). Therefore, by combining these operations, the best/average case time complexity is expected to be **O(nlgn)**.


# Execution

* mergeSort.java<br>
    Running mergeSort.java will generate a csv file named "MergeSortExecutionTimes.csv" with data points (n, executionTime).
    It will first output one run, with n = 10 elements in the list to ensure the implementation works.
    Then after a few minutes it will output "Done" to the console when all runs have completed.
* quickSort.java<br>
Running this quickSort.java will generate a csv file named "QuickSortExecutionTimes.csv"  with data points (n, executionTime).
It will first output one run for n = 10 to ensure the implementation works properly.
Then after a few minutes it will output "Done" to the console when all runs have completed.
