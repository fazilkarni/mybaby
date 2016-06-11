package com.sg;
public class MergeSort {

	public static void main(String[] args) {
		int[] a={10,5,9,8,3,4,2,1,6};
		mergeSort(a);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		

	}
	
	public static void mergeSort(int[] a){
		int n = a.length;
		if(n<2) return;
		
		int mid = n/2;
	
		int[] l = new int[mid];
		int[] r = new int[n-mid];
		for(int i=0;i<mid;i++){
			l[i] = a[i];
		}
		
		for(int j=0;j<n-mid;j++){
			r[j] = a[mid+j];
		}
		mergeSort(l);
		mergeSort(r);		
		merge(l,r,a);
		}

	public static void merge(int[] l,int[] r, int[] a){
		int leftLength = l.length;
		int rightLength = r.length;
		int i=0,j=0,k=0;
		while(i<leftLength&&j<rightLength){
			if(l[i]<r[j]){
				a[k]=l[i];
				i++;
			}else{
				a[j]=r[j];
				j++;
			}
			k++;
		}
		
		while(i<leftLength){
			a[k]=l[i];
			k++;
			i++;
		}
		
		while(j<rightLength){
			a[k] = r[j];
			k++;
			j++;
		}
	}

}
