/** A class that implements the MergeSort algorithm. 
 * @author Jessica Margala
 */
import java.lang.Math;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mergeSort {
	
	// Global array S
	public static int S[] = {};
	
	/**
	 * Prints array for testing purposes to ensure correctness
	 * @param S (the array requested to be print)
	 */
	public static void printArray(int S[])
	{
		int n = S.length;
		System.out.print("[ ");
		for (int i = 0; i < n; ++i)
			System.out.print(S[i] + " ");
		System.out.println("]"); 
	}
    
	/**
	 * Method that generates an array initialized with random numbers
	 * @param n (size of requested array)
	 * @return an array of size n 
	 */
    public static int[] getArray(int n){
    	
    	int array[] = new int[n];
    	Random rand = new Random();
    	
    	for(int i = 0; i < array.length; i++)
    	{
    		array[i] = rand.nextInt();
    	}
		return array;
    }
    /**
     * Method that merges two sorted arrays into one sorted array
     * @param low (index of lower end of array)
     * @param mid (index of middle point in array)
     * @param high (index of upper end of array)
     */
    void merge(int low, int mid, int high)
    {
        // Updated the mid and high values of list
    	// New sizes of the two temp arrays
        int mid1 = mid - low + 1;
        int high1 = high - mid;
 
        // Temporary arrays for merging
        // U holds left side of list
        // V holds right side of list
        int U[] = new int[mid1];
        int V[] = new int[high1];
 
        // Moving data into temporary arrays from S[]
        for (int i = 0; i < mid1; ++i)
            U[i] = S[low + i];
        for (int j = 0; j < high1; ++j)
            V[j] = S[mid + 1 + j];
        
        // Initial indexes of temporary arrays
        int i = 0, j = 0;
        // Initial index of final S[] array
        int k = low;
        
        // Begin merging the temporary arrays into S[] appropriately
        while (i < mid1 && j < high1) {
            if (U[i] <= V[j]) {
                S[k] = U[i];
                i++;
            }
            else {
                S[k] = V[j];
                j++;
            }
            k++;
        }
 
        // Move remaining elements from U[] into S[]
        while (i < mid1) {
            S[k] = U[i];
            i++;
            k++;
        }
 
        // Move remaining elements from V[] into S[]
        while (j < high1) {
            S[k] = V[j];
            j++;
            k++;
        }
    }
    
    /**
     * Method that sorts n integers in nondecreasing sequence.
     * @param low (index of lower end of array)
     * @param high (index of upper end of array)
     */
    void mergesort(int low, int high)
    {
        if (low < high) {
            
        	// Calculate the mid value 
            int mid = (int) Math.floor((low + high)/2);
 
            // Sort first and second halves
            mergesort(low, mid);
            mergesort(mid + 1, high);
 
            // Merge the two sorted halves
            merge(low, mid, high);
        }
    }
 
    /**
     * Main driver code
     * Tests mergesort and merge while also collecting data
     * for time complexity analysis
     * @param args
     */
	public static void main(String args[]) 
    {
		// Print out one run to ensure it is working
		S = getArray(10);
		System.out.println("Initial array:"); 
		printArray(S);
		mergeSort test = new mergeSort();
		test.mergesort(0, S.length - 1);
		System.out.println("Sorted array:"); 
		printArray(S);
		
    	// Array of different sizes, n, for data collection and testing
    	int sizes[] = {10000, 20000, 50000, 100000, 200000, 1000000, 2000000, 5000000, 
				6000000, 7000000, 8000000, 9000000, 10000000, 12000000, 
				13000000, 14000000, 15000000, 16000000, 17000000, 18000000, 
				19000000, 20000000, 25000000, 30000000, 35000000, 40000000, 
				45000000, 50000000, 55000000, 60000000, 65000000, 70000000, 
				75000000, 80000000, 85000000, 90000000, 95000000, 100000000, 
				120000000, 130000000, 140000000, 150000000, 160000000, 
				170000000, 180000000, 190000000, 200000000};

    	for (int i = 0; i < sizes.length; i++) { 
	
    		// Automatic size n from sizes array
    		int n = sizes[i];
    		// Call getArray to generate a random array of size n 
    		S = getArray(n);
    
    		// To measure the elapsed time for testing purposes
    		long startTime = System.currentTimeMillis();
    
    		mergeSort ob = new mergeSort(); 
    		ob.mergesort(0, S.length - 1); 
    
    		// To measure the elapsed time for testing purposes
    		long endTime = System.currentTimeMillis();
    		long timeElapsed = endTime - startTime;
    
    		// Creates/appends (n, timeElapsed) to csv file for documentation
    		try {
    			// Data to be written to file
    			String data = n + ", " + timeElapsed + "\n";
        
    			// File that data should be written to
    			File dataFile = new File("MergeSortExecutionTimes.csv");

    			// Check if file exists, if not make it, if yes then append to it 
    			if (!dataFile.exists()) {
    				dataFile.createNewFile();
    				FileWriter fw = new FileWriter(dataFile.getName(), true);
    				fw.write(data);
    				fw.close();
    			}
    			else {
    				String file = dataFile.getAbsolutePath();
    				FileWriter fw = new FileWriter(file, true);
    				fw.write(data);
    				fw.close();
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		} 
    	} 	
    	System.out.print("Done");  
    }
}

