import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
    static int R, C, pipeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pipeCount = 0;

        boolean[][] map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'x') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            recur(map, i, 0);
        }
        System.out.println(pipeCount);
    }

    private static boolean recur(boolean[][] map, int r, int c) {
        // 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 탐색한다
        int[] dx = {1, 1, 1};
        int[] dy = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];

            // 다음 지점이 C이면 -> 현재 지점이 빵집에 위치한다면 연결 성공
            if (nc == C) {
                pipeCount++;
                return true;
            }

            // 지나간 지점에 전부 true로 설정
            if (nr >= 0 && nr < R && !map[nr][nc]) {
                map[nr][nc] = true;
                if (recur(map, nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
}
