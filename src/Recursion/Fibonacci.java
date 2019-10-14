/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Ryan
 */
import java.util.Scanner;

class Fibonacci {
  public int fib(int n, int[] cache) {
    // fib with cache and memoization
    if (n == 0) return 0; 
    else if (n == 1) return 1; 
    else if (cache[n] != 0) {
      // already computed
      return cache[n]; // return cache
    } else {
      // compute it
      cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
      return cache[n];
    }
  }

  public int fibnormal(int n) {
    // this does fib normally without cache/memoization
    if (n == 0) return 0; 
    else if (n == 1) return 1; 
    else return fibnormal(n - 1) + fibnormal(n - 2); 
  }

  public static void main(String[] args) {
    Fibonacci a = new Fibonacci();
    Scanner s = new Scanner(System.in); 
    System.out.println("Input a number:");
    int fibnumber = s.nextInt();
    s.close();

    // Run fib with cache and calculate time used
    int[] cache = new int[fibnumber + 1];
    long pretime = System.currentTimeMillis();
    System.out.println("Fib num with memoization: " + a.fib(fibnumber, cache));
    long posttime = System.currentTimeMillis(); 
    System.out.println("Memoization Time in milliseconds: " + (posttime - pretime));

    // run fib without caching and compute time
    long normalpretime = System.currentTimeMillis(); 
    System.out.println("Fib num without memoization: " + a.fibnormal(fibnumber));
    long normalposttime = System.currentTimeMillis();
    System.out.println("No memoization time in milliseconds: " + (normalposttime - normalpretime));
  }
}