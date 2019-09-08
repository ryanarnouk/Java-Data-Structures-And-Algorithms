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
public class BinarySearch {
    public int searchArray(int[] array, int number) {
        int low = 0; 
        int high = array.length - 1; 
        while (low <= high) {
            int mid = (low + high) / 2; 
            if (array[mid] > number) {
                // left array
                high = mid - 1;
            } else if (array[mid] < number) {
                // right array
                low = mid + 1;
            } else if (array[mid] == number) {
                return mid;
            }
        }
        return -1; 
    }
    
    public static void main (String args[]) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80};
        BinarySearch a = new BinarySearch();
        System.out.println("Element found at position: " + a.searchArray(array, 50));
    }
}
