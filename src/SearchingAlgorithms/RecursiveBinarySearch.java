/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAlgorithms;

/**
 *
 * @author Ryan
 */
public class RecursiveBinarySearch {
    public static int binarySearch(int[] array, int number, int low, int high) {
        int mid = (low + high) / 2;
        if (high < low) {
            return -1; 
        }
        if (array[mid] > number) {
            // left array
            return binarySearch(array, number, low, mid - 1);
        } else if (array[mid] < number) {
            // right array
            return binarySearch(array, number, mid + 1, high);
        }
        if (number == array[mid]) {
            return mid;
        }
        return -1;
    }
    
    public static void main (String args[]) {
        int[] array = {22, 33, 44, 55, 66, 77, 88, 99};
        int result = binarySearch(array, 77, 0, array.length - 1);
        System.out.println("Element found at index: " + result);
    }
}
