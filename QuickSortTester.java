/*
Burgers - Eric Chen, Aryan Bhatt, Melanie Chow
APCS2 pd4
Lab01 -- What Does the Data Say?
2017-03-10
 */

/*======================================
  class MergeSortTester

  ALGORITHM:
  First, it checks if the length of the given array 'arr' is 1, and if so, it return arr.  Otherwise, it splits arr into two different int arrays: a and b.  It then merges the two after they get recursively sorted.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n)

  Mean execution times for dataset of size n:
  Batch size: 10000
  n=1       time: 64
  n=10      time: 875
  n=100     time: 11524
  n=200     time: 22394
  n=300     time: 34510
  n=400     time: 46232
  n=500     time: 58646
  ...
  n=10000   time: 1462788

  ANALYSIS:
  The algorithm is O(n) runtime, as shown by a graph of time versus n, which is more or less a straight line.
  ======================================*/

public class QuickSortTester 
{
    /*quicksort code*/
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
     * We find the start time in nanoseconds, run the sort() method, then subtract it from the end time in nanoseconds.  This number is added to a total, which will be divided by the batch size and printed to the terminal.
     ******************************/
    public static void main( String[] args ) 
    {

	// SET BATCHSIZE HERE
	int batchSize = 10000;

	// SET BIGSIZE HERE
	int bigSize = 500;
	
	
	int[] n1 = new int[1];
	int[] n10 = new int[10];
	int[] n100 = new int [100];
	int[] nbs = new int[bigSize];

	long n1t = 0;
	long n10t = 0;
	long n100t = 0;
	long nbst = 0;

	// Runs 10000 times
	for ( int j = 0 ; j < batchSize ; j++ ) {

	    n1[0] = (int)( Math.random() * 5 );

	    for ( int i = 0 ; i < 10 ; i++ ) {
		n10[i] = (int)( Math.random() * 50 );
	    }

	    for ( int i = 0 ; i < 100 ; i++ ) {
		n100[i] = (int)( Math.random() * 500 );
	    }

	    for ( int i = 0 ; i < bigSize ; i++ ) {
		nbs[i] = (int)( Math.random() * 1000 );
	    }

	    // Runtime Finder
	    long start;
	    long elapsed;

	    // n1
	    start = System.nanoTime();
	    quicksort( n1,0,n1.length-1 );
	    elapsed = System.nanoTime() - start;
	    n1t += elapsed;

	    // n10
	    start = System.nanoTime();
	    quicksort( n10,0,n10.length-1 );
	    elapsed = System.nanoTime() - start;
	    n10t += elapsed;

	    // n100
	    start = System.nanoTime();
	    quicksort( n100,0,n100.length-1 );
	    elapsed = System.nanoTime() - start;
	    n100t += elapsed;

	    // n of bigSize
	    start = System.nanoTime();
	    quicksort( nbs,0,nbs.length-1 );
	    elapsed = System.nanoTime() - start;
	    nbst += elapsed;
	    
	}

	n1t /= batchSize;
	n10t /= batchSize;
	n100t /= batchSize;
	nbst /= batchSize;

	System.out.println( "    Average runtime with 1 item: " + n1t );
	System.out.println( "  Average runtime with 10 items: " + n10t );
	System.out.println( " Average runtime with 100 items: " + n100t );
	System.out.println( " Average runtime with " + bigSize + " items: " + nbst );

    }//end main

}//end class
