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
public class InsertionSort {
    public void sortArray(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1; 
            while (i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i = i - 1; 
            }
            array[i + 1] = key;
        }
    }
    
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main (String args[]) {
        int[] array = {5, 1, 2, 4, 3};
        InsertionSort a = new InsertionSort(); 
        a.sortArray(array); 
        a.printArray(array);
    }
}
