/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicArray;

/**
 *
 * @author Ryan
 */
public class DynamicArray {
    public static void main(String[] args) {
        // TODO code application logic here
        DArray<Integer> test = new DArray(1);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.remove(1);
        test.add(2, 1);
        test.print();
        
        // test linear and binary search
        System.out.println("Using a linear search, the element was found at index: " + test.linearfind(2));
        System.out.println("Using a binary search, the element was found at index: " + test.binearysearch(2));
    }
}
