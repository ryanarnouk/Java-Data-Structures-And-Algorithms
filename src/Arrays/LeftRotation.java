/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author Ryan
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class LeftRotation {
    static void LeftRotation(int[] a, int size, int rotations) {
        int[] rotated = new int[size];
        

        System.arraycopy(a, rotations, rotated, 0, size - rotations);
        System.arraycopy(a, 0, rotated, size - rotations, rotations);
        printarray(rotated);
    }
    
    static void printarray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
            System.out.print(nums[i] + " ");
        }
        
        System.out.println();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {       
        System.out.println("Test by passing in numbers in console.");
        String[] nd = scanner.nextLine().split(" ");
                
        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        LeftRotation(a, n, d);
        
        scanner.close();
    }
}
