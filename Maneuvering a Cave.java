/*Maneuvering a Cave
Imagine a robot sitting on the upper left-hand corner of an MxN grid. It starts from (0,0) and destination is (M-1,N-1).The robot can only move in two directions: right and down. The robot has to reach the lower right-hand corner of the NxN grid. Write a program to calculate the total number of ways a robot can reach the destination.
Input Format:

The inputs m and n which denote the size of the grid

Output Format:

Print the total number of ways a robot can reach the destination

Sample Input:

5 5

Sample Output:

70*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int m = scanner.nextInt();
        int n = scanner.nextInt();
       
        int ways = countWays(m, n);
       
        System.out.println(ways);
    }
   
    public static int countWays(int m, int n) {
        int[][] dp = new int[m][n];
       
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
       
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
       
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
       
        return dp[m - 1][n - 1];
    }
}
