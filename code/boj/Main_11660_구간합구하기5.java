package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 표의 크기
        int N = Integer.parseInt(st.nextToken());
        // 합을 구해야 하는 횟수
        int M = Integer.parseInt(st.nextToken());

        // 표 -> 0이 아닌 1부터 시작하기 위해 크기를 N+1로 함
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1];
            }

            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1];

            System.out.println(answer);
        }
    }
}
