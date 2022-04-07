package ssafy.swea.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1953_탈주범검거 {
    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, R, C, L;
    static int[][] input;
    static boolean[][] visit;
    // 상하좌우 순서
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            input = new int[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 맨홀의 위치
            Location manhole = new Location(R, C);

            sb.append(bfs(manhole)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(Location manhole) {
        Queue<Location> queue = new LinkedList<>();
        Queue<Location> temp = new LinkedList<>();
        int count = 0;
        int time = 0;

        visit[manhole.r][manhole.c] = true;
        queue.offer(manhole);

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Location currentLocation = queue.poll();
                List<Location> nextLocations = getNextLocations(currentLocation);
                count++;

                for (Location nextLocation : nextLocations) {
                    visit[nextLocation.r][nextLocation.c] = true;
                    temp.offer(nextLocation);
                }
            }
            // 시간을 채우면 bfs를 빠져나오고 count를 리턴
            if (++time == L) {
                return count;
            }

            queue.addAll(temp);

            temp.clear();
        }

        return count;
    }

    private static List<Location> getNextLocations(Location currentLocation) {
        List<Location> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int nr = currentLocation.r + dr[i];
            int nc = currentLocation.c + dc[i];
            Location nextLocation = new Location(nr, nc);

            // 다음 위치가 배열의 범위를 벗어나면 continue
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            // 이미 방문한 위치라면 continue
            if (visit[nr][nc]) continue;
            // 내 위치에서 다음 위치로 갈 수 있는지, 다음 위치에서 내 위치로 올 수 있는지 체크하고 둘 중 하나라도 안되면 continue
            if (!isPossible(currentLocation, nextLocation) || !isPossible(nextLocation, currentLocation)) continue;

            list.add(new Location(nr, nc));
        }

        return list;
    }

    private static boolean isPossible(Location currentLocation, Location nextLocation) {
        int type = input[currentLocation.r][currentLocation.c];

        switch (type) {
            case 1:
                return true;
            case 2:
                return currentLocation.r + 1 == nextLocation.r || currentLocation.r - 1 == nextLocation.r;
            case 3:
                return currentLocation.c + 1 == nextLocation.c || currentLocation.c - 1 == nextLocation.c;
            case 4:
                return currentLocation.r - 1 == nextLocation.r || currentLocation.c + 1 == nextLocation.c;
            case 5:
                return currentLocation.r + 1 == nextLocation.r || currentLocation.c + 1 == nextLocation.c;
            case 6:
                return currentLocation.r + 1 == nextLocation.r || currentLocation.c - 1 == nextLocation.c;
            case 7:
                return currentLocation.r - 1 == nextLocation.r || currentLocation.c - 1 == nextLocation.c;
        }

        return false;
    }
}
