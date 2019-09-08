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
public class LinearSearch {
    public int searchArray (int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main (String args[]) {
        int[] array = {10, 42, 68, 21, 33};
        LinearSearch a = new LinearSearch();
        System.out.println("Element is at index: " + a.searchArray(array, 68));;
    }
}
