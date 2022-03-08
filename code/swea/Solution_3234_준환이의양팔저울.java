package com.ssafy.ws0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
    static int N, sum;
    static int count;
    static int[] input;
    static int[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        factorial = new int[11];

        factorial[1] = 1;
        for (int i = 2; i < 11; i++) {
            factorial[i] = i * factorial[i - 1];
        }

        for (int tc = 1; tc <= T; tc++) {
            sum = 0;
            count = 0;

            N = Integer.parseInt(br.readLine());

            input = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                sum += input[i];
            }
            // 입력 끝
            permutation(0, 0, 0, 0);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(count);

            System.out.println(sb);
        }
    }

    private static void permutation(int cnt, int flag, int left, int right) {
        if (left < right) return;

        if (cnt == N) {
            count++;
            return;
        }

        // left - right = sum - left - right
        if (2 * left >= sum) {
            count += (1 << N - cnt) * factorial[N - cnt];
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;

            // 추를 왼쪽에 놓는 경우
            permutation(cnt + 1, flag | 1 << i, left + input[i], right);

            // 추를 오른쪽에 놓는 경우
            permutation(cnt + 1, flag | 1 << i, left, right + input[i]);
        }
    }
}
