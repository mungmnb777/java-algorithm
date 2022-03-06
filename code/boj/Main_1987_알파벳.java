package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
    static int R, C, max;
    static char[][] map;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = 0;

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        recur(new boolean[26], 0, 0, 0);
        System.out.println(max);
    }

    private static void recur(boolean[] visit, int r, int c, int count) {
        // 만약 현재 위치가 이미 방문한 알파벳이라면 리턴
        if (visit[map[r][c] - 'A']) {
            max = Math.max(max, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            visit[map[r][c] - 'A'] = true;
            recur(visit, nr, nc, count + 1);
            visit[map[r][c] - 'A'] = false;
        }
    }
}
