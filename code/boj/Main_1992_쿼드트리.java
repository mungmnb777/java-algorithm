package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        recur(N, 0, 0);

        System.out.println(sb);
    }

    private static void recur(int N, int x, int y) {
        // 각각의 사분면의 블럭 넓이
        int block = N * N / 4;

        sb.append("(");

        int sum = 0;

        if (N == 1) {
            sb.setLength(0);
            sb.append(arr[0][0]);
            return;
        }

        // 전체 탐색
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == 0 || sum == block * 4) {
            sb.setLength(0);
            sb.append(arr[y][x]);
            return;
        }

        // 부분 탐색
        sum = 0;
        // 1사분면 탐색
        for (int i = y; i < y + N / 2; i++) {
            for (int j = x; j < x + N / 2; j++) {
                sum += arr[i][j];
            }
        }
        // sum이 0이거나 block이면 사분면 내의 모든 값은 0 또는 1이다.
        if (sum == 0 || sum == block) {
            sb.append(arr[y][x]);
        } else {
            recur(N / 2, x, y);
        }

        sum = 0;
        // 2사분면 탐색
        for (int i = y; i < y + N / 2; i++) {
            for (int j = x + N / 2; j < x + N; j++) {
                sum += arr[i][j];
            }
        }
        // sum이 0이거나 block이면 사분면 내의 모든 값은 0 또는 1이다.
        if (sum == 0 || sum == block) {
            sb.append(arr[y][x + N / 2]);
        } else {
            recur(N / 2, x + N / 2, y);
        }

        sum = 0;
        // 3사분면 탐색
        for (int i = y + N / 2; i < y + N; i++) {
            for (int j = x; j < x + N / 2; j++) {
                sum += arr[i][j];
            }
        }
        // sum이 0이거나 block이면 사분면 내의 모든 값은 0 또는 1이다.
        if (sum == 0 || sum == block) {
            sb.append(arr[y + N / 2][x]);
        } else {
            recur(N / 2, x, y + N / 2);
        }

        sum = 0;
        //4사분면 탐색
        for (int i = y + N / 2; i < y + N; i++) {
            for (int j = x + N / 2; j < x + N; j++) {
                sum += arr[i][j];
            }
        }
        // sum이 0이거나 block이면 사분면 내의 모든 값은 0 또는 1이다.
        if (sum == 0 || sum == block) {
            sb.append(arr[y + N / 2][x + N / 2]);
        } else {
            recur(N / 2, x + N / 2, y + N / 2);
        }
        sb.append(")");
    }
}
