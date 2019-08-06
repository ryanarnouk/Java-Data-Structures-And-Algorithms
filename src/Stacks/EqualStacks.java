/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

/**
 *
 * @author Ryan
 */
import java.io.*;
import java.util.*;

public class EqualStacks {
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        // init all the stacks
        Stack<Integer> firststack = new Stack<Integer>();
        Stack<Integer> secondstack = new Stack<Integer>();
        Stack<Integer> thirdstack = new Stack<Integer>();
        int firststacksum = 0;
        int secondstacksum = 0;
        int thirdstacksum = 0;

        // push each element into stacks reversed and add to the sum
        // push the sum of all the cylinders to the stack 
        for (int i = h1.length - 1; i >= 0; i--) {
            firststacksum += h1[i];
            firststack.push(firststacksum);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            secondstacksum += h2[i];
            secondstack.push(secondstacksum);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            thirdstacksum += h3[i];
            thirdstack.push(thirdstacksum);
        }

        while (true) {
            // if stack is empty
            if (firststack.isEmpty() || secondstack.isEmpty() || thirdstack.isEmpty())
                return 0;

            // set sum to last element in the stack
            firststacksum = firststack.peek();
            secondstacksum = secondstack.peek();
            thirdstacksum = thirdstack.peek();

            // check if all the sums are equal
            if (firststacksum == secondstacksum && secondstacksum == thirdstacksum) {
                return firststacksum;
            }

            // find biggest stack and remove last element 
            if (firststacksum >= secondstacksum && firststacksum >= thirdstacksum) {
                // first stack
                firststack.pop();
            } else if (secondstacksum >= thirdstacksum && secondstacksum >= thirdstacksum) {
                // second stack
                secondstack.pop();
            } else if (thirdstacksum >= secondstacksum && thirdstacksum >= firststacksum) {
                // third stack
                thirdstack.pop();
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}