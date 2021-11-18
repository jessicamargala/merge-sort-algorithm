/** A class that implements the QuickSort algorithm. 
 * @author Jessica Margala
 */
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class quickSort {
	
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
	 * Method to partiton array into two sub-arrays
	 * @param low (index for the lower element in array)
	 * @param high (index for upper element in array)
	 * @param pivotpoint (index of desired pivot item)
	 * @return an updated pivot index
	 */
	private static int partition(int low, int high, int pivotpoint) {
		int i;
		int j;
		int pivotitem;
		pivotitem = S[high]; // Choose last item for pivotitem
		j = low - 1;
		for(i = low; i < high; i++) {
			if(S[i] < pivotitem) {
				j++;
				// Exchange S[i] and S[j]
				int temporary = S[i];
				S[i] = S[j];
				S[j] = temporary;
			}
		}
		pivotpoint = j;
		// Exchange S[low] and S[pivotpoint], putting pivotitem at pivotpoint
		int temp2 = S[j + 1]; 
        S[j + 1] = S[high]; 
        S[high] = temp2; 
		
		// Return the integer points to the updated pivot index
        return j + 1;
	}
	
	/**
	 * Method to sort n integers in nondecreasing sequence
	 * @param low (index of lower element in array)
	 * @param high (index of upper element in array)
	 */
	public void quicksort(int low, int high)
	{
		if(high > low) {
			int pivotpoint = S[high];
			// Variable to keep track of new partition, given the pivotpoint
			int partition = partition(low, high, pivotpoint);
			quicksort(low, partition - 1);
			quicksort(partition + 1, high);
		}
	}
    
    /**
     * Main driver code
     * Tests quicksort and partition while also collecting data
     * for time complexity analysis
     * @param args
     */
    public static void main(String args[]) 
    { 	
		// Print out one run to ensure it is working
		S = getArray(10);
		System.out.println("Initial array:"); 
		printArray(S);
		quickSort test = new quickSort();
		test.quicksort(0, S.length - 1);
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
    		
    		// Size of array to be sorted from sizes[]
    		int n = sizes[i];
    		
        	// Call getArray to generate a random array of size n 
        	S = getArray(n);
        	
        	// Length of list to be sorted
            int n1 = S.length; 
            
        	// To measure the elapsed time for testing purposes
            long startTime = System.currentTimeMillis();
      
            quickSort ob = new quickSort(); 
            ob.quicksort(0, (n1 - 1)); 
            
            // To measure the elapsed time for testing purposes
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            
            // Creates/appends (n, timeElapsed) to csv file for documentation
            try {
                // Data to be written to file
                String data = n + ", " + timeElapsed + "\n";
                
                // File that data should be written to
                File dataFile = new File("QuickSortExecutionTimes.csv");

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
