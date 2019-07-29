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

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                // opening bracket
                stack.push(s.charAt(i));
            } else {
                // closing bracket
                if (stack.isEmpty()) {
                    return "NO"; // doesnt contain starting bracket
                }
                if (s.charAt(i) == ')' && stack.peek() != '(' ||
                        s.charAt(i) == ']' && stack.peek() != '[' || 
                        s.charAt(i) == '}' && stack.peek() != '{') {
                    // ensure match 
                    return "NO";
                }
                stack.pop(); // pop if match
            }
        }
        // check to see if stack is empty
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample Input 
        // 4 length
        // {[]} brackets
        // output: YES
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.print(result);
        }

        scanner.close();
    }
}
