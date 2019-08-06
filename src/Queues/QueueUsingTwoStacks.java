/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author Ryan
 */
import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int query = scan.nextInt();
            if (query == 1) {
                // enqueue element
                int x = scan.nextInt(); 
                queue.add(x);
            } else if (query == 2) {
                // dequeue element 
                queue.poll();
            } else {
                // print
                System.out.println(queue.peek());
            }
        }
    }
}
