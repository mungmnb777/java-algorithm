package boj.silver;

import java.util.Scanner;

public class Main_1463_1로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }
            min = Math.min(min, dp[i - 1] + 1);

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
