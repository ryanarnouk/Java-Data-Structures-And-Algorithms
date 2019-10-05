/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAlgorithms;

/**
 *
 * @author Ryan
 */
public class MergeSort {
    void merge(int array[], int l, int m, int r) {
        // merge the arrays
        // find the sizes of the two subarrays to merge
        int n1 = m - l + 1;
        int n2 = r - m; 
        
        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        // copy data to temp arrays
        for (int i = 0; i < n1; ++i) 
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }
        
        // merge the temp arrays
        int i = 0, j = 0; // init the index of first and second arrays
        
        // init index of merged subarray array
        int k = l; 
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        
        // copy the remaining items of L if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        
        // copy remaining items of R 
        while (j < n2) {
            array[k] = R[j];
            j++; 
            k++;
        }
    }
    
    // main function that sorts array using merge()
    void sort(int array[], int l, int r) {
        if (l < r) {
            // find the middle point
            int m = (l+r)/2;
            
            // sort first and second halves
            sort(array, l, m);
            sort(array, m+1, r);
            
            // merge the sorted halves
            merge(array, l, m, r);
        }
    }
    
    void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main (String args[]) {
        int[] array = {5, 2, 3, 4, 1};
        MergeSort a = new MergeSort();
        a.sort(array, 0, array.length - 1);
        System.out.println("Sorted Array:");
        a.printArray(array);
    }
}
