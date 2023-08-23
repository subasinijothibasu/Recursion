/*Optimal Stealing
There are n houses build in a line which contains some value in it. A thief is going to steal the maximal value of these houses, but he can’t steal in two adjacent houses. What is the maximum stolen value.
Size of an array: 4 Input: 4 3 2 11 Output: 15
Case 1
Case 2
Case 3
Input (stdin)
4
4 3 2 11

Output (stdout)
15*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = scanner.nextInt();
        }

        int maxStolenValue = maxStolenValue(houses);
        System.out.println(maxStolenValue);
    }

    public static int maxStolenValue(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return houses[0];
        } else if (n == 2) {
            return Math.max(houses[0], houses[1]);
        }

        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
        }

        return dp[n - 1];
    }
}

