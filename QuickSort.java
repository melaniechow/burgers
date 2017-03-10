/*
Melanie Chow
APCS2 pd4
HW15 -- So So Quick
2017-03-09

The algorithm works by partitioning the array by whatever value is in the middle until the bounds are the same. Once we partition it, we know that everything to the left of that number is less than the pvtPos value and everything to the right is greater. Thus, we then go on to partition the next two...and so on and so on. Once the left and right bound becomes the same, we know that that portion of the array is sorted. 
*/


public class QuickSort{
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

    public static void main(String[] args){
	int[] a=new int[] {4,5,8,2,9,17};
	quicksort(a,0,a.length-1);
	printarray(a);
    }
}
    
