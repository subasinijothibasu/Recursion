/*Reaching Nth step in staircase - Count ways
A naughty kid is climbing stairs with N steps. From any step, he can take 1 step or 2 steps at a time. Find the total distinct ways of reaching Nth step. Assume he is standing on 0th step.
Input Format :

Input consists of an Integer



Output Format:

Output consists of an Integer



Sample Input:

2



Sample Output:

2            */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int n = scanner.nextInt();
        int ways = countWays(n);
       
        System.out.println(ways);
    }
   
    public static int countWays(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
       
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
       
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
       
        return dp[n];
    }
}
