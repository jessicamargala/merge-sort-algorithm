# Merge Sort Algorithm
Implementation of **MergeSort algorithm**. 
Using the Divide and Conquer approach, Merge Sort creates a nondecreasing list of n sorted integers, by recursively dividing the list into 2 sub-arrays of n/2 integers, then solving each sub-array by recursively sorting it, and finally, combining the solutions to the sub-arrays by merging them into one single sorted array S. Also, by not using an in-place sort method for the mergesort implementation, temporary arrays U and V are needed, using extra space. 
# Time Complexity
The array is repeatedly being divided into two equally sized parts. However, if the number of elements n is doubled, there is only one additional division required. Therefore, the number of divisions can be calculated by *log(base 2)n*. Additionally, for each merge step, we merge n integers. Since there are no nested loops in the implementation, we can expect it to operate with linear complexity, meaning that if n is doubled, the time to merge would double as well. Ultimately, n integers multiplied by *log(base 2)n* division/merge steps, gives us a Time Complexity of **O(nlgn)**.
# Execution
Running this file will generate a csv file named "MergeSortExecutionTimes.csv" with data points (n, executionTime). 
It will first output one run, with n = 10 elements in the list to ensure the implementation works. 
Then after a few minutes it will output "Done" to the console when all runs have completed.
