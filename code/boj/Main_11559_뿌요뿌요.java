package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11559_뿌요뿌요 {
    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Location> removedLocations = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;

        while (bfs(map)) {
            result++;
            fall(map);
        }

        System.out.println(result);
    }

    private static void fall(char[][] map) {
        for (Location removedLocation : removedLocations) {
            for (int i = removedLocation.r; i > 0; i--) {
                map[i][removedLocation.c] = map[i - 1][removedLocation.c];
                map[i - 1][removedLocation.c] = '.';
            }
        }

        removedLocations.clear();
    }

    private static boolean bfs(char[][] map) {
        boolean isRemoved = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.') continue;

                Queue<Location> queue = new LinkedList<>();
                boolean[][] visit = new boolean[12][6];
                // 똑같은 단어인 것이 몇 개인지 찾아내야 한다.
                char currentCharacter = map[i][j];
                int count = 0;

                queue.offer(new Location(i, j));
                visit[i][j] = true;

                while (!queue.isEmpty()) {
                    // 방문 시 count를 1 늘려준다..
                    Location currentLocation = queue.poll();
                    count++;

                    for (int k = 0; k < 4; k++) {
                        int nr = currentLocation.r + dr[k];
                        int nc = currentLocation.c + dc[k];

                        if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
                        if (visit[nr][nc]) continue;
                        if (map[nr][nc] != currentCharacter) continue;

                        queue.offer(new Location(nr, nc));
                        visit[nr][nc] = true;
                    }
                }

                if (count >= 4) {
                    isRemoved = true;
                    removeBlock(map, visit);
                }
            }
        }
        return isRemoved;
    }

    private static void removeBlock(char[][] map, boolean[][] visit) {
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 6; l++) {
                if (visit[k][l]) {
                    map[k][l] = '.';
                    removedLocations.add(new Location(k, l));
                }
            }
        }
    }
}
