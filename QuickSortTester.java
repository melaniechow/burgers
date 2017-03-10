/*
Burgers -- Aryan Bhatt, Melanie Chow, Eric Chen
APCS2 pd4
LAB01 -- What Does the Data Say?
2017-03-08
 */

import cs1.Keyboard;

/**======================================
  class QuickSortTester

  ALGORITHM:   We tested the runtime by creating arrays of n items and timing how long it would take to perform quicksort on those arrays. We find the start time in nanoseconds, run the sort() method, then subtract it from the end time in nanoseconds.  This number is added to a total, which will be divided by the batch size and printed to the terminal.  

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlogn)

  Mean execution times for dataset of size n:
  Batch size: 10000 (for more data points and the analysis, read README file)

  n=1000     time: 91445
  n=2000     time: 183769
  n=3000     time: 313521
  n=4000     time: 405829
  n=5000     time: 500748
  n=6000     time: 610279
  n=7000     time: 730446
  n=8000     time: 845869
  n=9000     time: 940874
  n=10000    time: 1129605

  ======================================**/

public class QuickSortTester {
    
    // Melanie's QuickSort.java
    public static void swap(int[] arr, int i, int j){
	int first=arr[i];
	int second=arr[j];
	arr[i]=second;
	arr[j]=first;
    }

    public static void printarray(int [] a){
	String retStr="[";
	for (int i=0; i<a.length; i++){
	    retStr+=" "+a[i];
	}
	System.out.println( retStr+=" ]");
    }

    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal=arr[pvtPos];
	swap(arr,pvtPos,right);
	int storePos=left;
	for (int i=left; i<right; i++){
	    if (arr[i]<=pvtVal){
		swap (arr,storePos,i);
		storePos+=1;
	    }
	}
	swap(arr,right,storePos);
	return storePos;
    }

    public static void quicksort(int[] arr, int left,int right){
	if (left<right){
	    int pvtPos=partition(arr,left,right,(left+right)/2);
	    quicksort(arr,left, pvtPos-1);
	    quicksort(arr,pvtPos+1,right);
	}
    }

    /******************************
     * execution time analysis 
     ******************************/
    public static void main( String[] args ) {

	System.out.print( "Please specify test array size: " );
	int size = Keyboard.readInt();
	/**
	System.out.print( "Please set how many trials you would like to run: " );
	int batchSize = Keyboard.readInt();
	**/

	// SET BATCHSIZE HERE
	int batchSize = 5000;
	 
	/**
	 // SET SIZE HERE
	 int size = 500;
	**/
	
	int[] n = new int[size];
	
	long t = 0;

	// Runs batchSize times
	for ( int j = 0 ; j < batchSize ; j++ ) {
	    for ( int i = 0 ; i < size ; i++ ) {
		n[i] = (int)( Math.random() * 1000 );
	    }

	    // Runtime Finder
	    long start;
	    long elapsed;

	    // n of bigSize
	    start = System.nanoTime();
	    quicksort( n, 0, size - 1 );
	    elapsed = System.nanoTime() - start;
	    t += elapsed;
	    
	}

	t /= batchSize;
	
	System.out.println( " Average runtime for " + batchSize + " runs with " + size + " items: " + t + " nanoseconds." );

    }//end main

}//end class
