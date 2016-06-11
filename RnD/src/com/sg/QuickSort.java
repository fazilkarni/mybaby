package com.sg;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {10,1};//,9,5,4,8,7,6,2,3};
		quickSort(a, 0, a.length);
		
		for(int i=0;i<a.length;i++)
		System.out.println(a[i]);

	}
	
	public static void quickSort(int[] a, int start, int end){
		if(start<end){
			int p = partitionIndex(a,start, end);
			quickSort(a,start,p-1);
			quickSort(a,p+1,end);
		}
	}
	
	public static int partitionIndex(int[] a,int start,int end){
		int pivot = a[end-1];
		
		int partition = start;
		for(int i=0;i<end;i++){
			if(a[i]<=pivot){
				int temp = a[partition];
				a[partition] = a[i];
						a[i] = temp;
						partition++;
				
			}
		}
		
		int temp = a[partition];
		a[partition] = pivot;
		a[end-1] = temp;
		
		return partition;
		
	}

}
