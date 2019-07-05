/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author Ryan
 */

import java.util.Arrays;
import java.util.Scanner;

public class GreedyForPies 
{
    public int gfr(int aStart, int[] A, int[] B, int bSkip, int bPickup, int[][][] cache) 
    {
        // base cases
        if (aStart >= A.length && bSkip > bPickup) return 0;//no pies left
        if (aStart == A.length - 1 && bSkip > bPickup) return A[aStart];
        if (aStart >= A.length && bSkip == bPickup) return B[bPickup];
        if (aStart == A.length - 1 && bSkip == bPickup) return Math.max(A[aStart],B[bPickup]);

        // B is sorted so whenever we skip an index we want it to be the smallest element
        // Since B is sorted we want to pickup from the end (the biggest one)

        // Pick from the group of the possible options and select biggest one
        if (cache[aStart][bSkip][bPickup+1] > 0)
        {
            // cache exists
            return cache[aStart][bSkip][bPickup+1];    
        }
        else {
            if (aStart < A.length && bSkip <= bPickup) 
            {
                cache[aStart][bSkip][bPickup+1] = Math.max (
                    Math.max(
                        Math.max(
                            A[aStart] + gfr(aStart + 2, A, B, bSkip, bPickup, cache), 
                            A[aStart] + gfr(aStart + 1, A, B, bSkip + 1, bPickup, cache)
                        ),
                        Math.max(
                            B[bPickup] + gfr(aStart + 1, A, B, bSkip, bPickup - 1, cache), 
                            B[bPickup] + gfr(aStart, A, B, bSkip + 1, bPickup - 1, cache)
                        )
                    ), 
                    Math.max(
                        gfr(aStart +1, A, B, bSkip, bPickup, cache), 
                        gfr(aStart, A, B, bSkip + 1, bPickup, cache)
                    )
                );
            } else if (aStart < A.length) 
            {
                cache[aStart][bSkip][bPickup+1] = Math.max(
                    A[aStart] + gfr(aStart + 2, A, B, bSkip, bPickup, cache), 
                    gfr(aStart + 1, A, B, bSkip, bPickup, cache)
                ); 
            } else 
            {
                int sum = 0;
                while(bPickup >= bSkip) 
                {
                    sum += B[bPickup];
                    bSkip++;
                    bPickup--;
                }
                cache[aStart][bSkip][bPickup+1] = sum;
            }
            // return the cache
            return cache[aStart][bSkip][bPickup+1];
        }
    }
    
    public static void main(String[] args) 
    {
        GreedyForPies a = new GreedyForPies(); 
        Scanner input = new Scanner(System.in);
        int aSize = input.nextInt();
        int[] A = new int[aSize];
        for(int n = 0; n < A.length; n++)
            A[n] = input.nextInt();
            
        int bSize = input.nextInt();
        int[] B = new int[bSize];
        for(int n = 0; n < B.length; n++)
            B[n] = input.nextInt();
            
        int[][][] cache = new int[A.length + 2][B.length + 1][B.length + 1];
        Arrays.sort(B);
        System.out.println( a.gfr(0, A, B, 0, B.length - 1, cache) );
    }
}
