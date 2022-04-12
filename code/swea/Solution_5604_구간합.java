package ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5604_구간합 {
    static long[] in = new long[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        in[0] = 45;
        for (int i = 1; i < 15; i++) {
            in[i] = 45 * (long) Math.pow(10, i) + in[i - 1] * 10;
        }

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            sb.append(sum(B) - sum(A == 0 ? 0 : A - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static long sum(long num) {
        String temp = Long.toString(num);

        int index = temp.length() - 1;

        if (index == 0) {
            return num * (num + 1) / 2;
        }

        long power = (long) Math.pow(10, index);

        long n = num / power;

        return n * in[index - 1] + (n * (n - 1) / 2) * power + (n * (num % power + 1)) + sum(num % power);
    }
}
