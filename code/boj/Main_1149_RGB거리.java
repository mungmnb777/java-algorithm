package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;

        int[][] dp = new int[n + 1][3];

        dp[1][0] = map[1][0];
        dp[1][1] = map[1][1];
        dp[1][2] = map[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + map[i][0], dp[i - 1][2] + map[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + map[i][1], dp[i - 1][2] + map[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + map[i][2], dp[i - 1][1] + map[i][2]);
        }

        min = Math.min(min, dp[n][0]);
        min = Math.min(min, dp[n][1]);
        min = Math.min(min, dp[n][2]);

        System.out.println(min);
    }
}
