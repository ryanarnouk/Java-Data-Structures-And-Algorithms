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
public class BubbleSort {
    public void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    public void printArray(int[] array) {
       for (int i = 0; i < array.length; i++) { 
           System.out.print(array[i] + " ");
       }
       System.out.println(); 
    }
    
    public static void main (String args[]) {
        int[] array = {5, 1, 2, 3, 4};
        BubbleSort a = new BubbleSort(); 
        a.sortArray(array);
        System.out.println("Sorted Array:");
        a.printArray(array);
    }
}
