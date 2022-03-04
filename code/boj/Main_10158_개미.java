package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 너비
        int w = Integer.parseInt(st.nextToken());
        // 높이
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        // 개미의 현재 열
        int c = Integer.parseInt(st.nextToken());
        // 개미의 현재 행
        int r = Integer.parseInt(st.nextToken());

        // 움직일 시간
        int t = Integer.parseInt(br.readLine());


        // 개미가 움직여야 하는 열의 수
        int tc = t % (2 * w);
        // 개미가 움직여야 하는 행의 수
        int tr = t % (2 * h);

        // 0일때 오른쪽, 1일때 왼쪽
        for (int i = 0, dirX = 0; i < tc; i++) {
            if (dirX == 0) {
                c++;
                if (c == w) dirX = 1;
            } else {
                c--;
                if (c == 0) dirX = 0;
            }
        }

        for (int i = 0, dirY = 0; i < tr; i++) {
            if (dirY == 0) {
                r++;
                if (r == h) dirY = 1;
            } else {
                r--;
                if (r == 0) dirY = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(c).append(" ").append(r);
        System.out.println(sb);
    }
}
