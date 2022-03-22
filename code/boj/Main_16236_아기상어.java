package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236_아기상어 {

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        // 현재 위치
        Location currentLocation;
        // 현재 상어 크기
        int size;
        // 상어 레벨 업을 위한 경험치
        int exp;
        // 이동 시간
        int time;

        public Shark(int x, int y) {
            this.currentLocation = new Location(x, y);
            this.size = 2;
            this.exp = 0;
            this.time = 0;
        }

        public boolean move(int[][] map) {
            // bfs를 위한 큐 생성
            Queue<Location> queue = new LinkedList<>();
            // 탐색되는 위치를 넣기 위한 큐 생성
            Queue<Location> subQueue = new LinkedList<>();

            // 방문 체크를 위한 visit 배열 생성
            int N = map.length;
            boolean[][] visit = new boolean[N][N];

            // 탐색 성공 시 이동하며 체크할 시간 변수
            int t = 0;

            // 처음 위치는 방문했다고 체크한다.
            queue.offer(currentLocation);
            visit[currentLocation.y][currentLocation.x] = true;

            // 탐색을 위한 dx, dy 배열 상, 좌, 우, 하 순
            int[] dx = {0, -1, 1, 0};
            int[] dy = {-1, 0, 0, 1};

            // 거리가 같으면 우선순위가 높은 먹이를 먼저 먹는다
            Location priority = new Location(N, N);

            while (true) {
                // 현재 바라보고 있는 위치
                Location temp = queue.poll();

                int feed = map[temp.y][temp.x];

                // 먹을 수 있는 먹이라면 우선순위 객체에 넣는다.
                if (feed > 0 && feed < size) {
                    // temp의 y가 priority보다 위에 있으면
                    if (temp.y < priority.y) {
                        priority = temp;
                    } else if (temp.y == priority.y && temp.x < priority.x) {
                        priority = temp;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    // 다음 위치 설정
                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];

                    // 다음 위치가 맵의 범위를 넘어서면 안됨
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    // 다음 위치에 있는 물고기의 사이즈가 현재 상어의 사이즈보다 크면 안됨
                    if (map[ny][nx] > size) continue;

                    // 이미 방문했으면 가면 안됨
                    if (visit[ny][nx]) continue;

                    // 이동 가능한 위치라면 큐에 넣고 방문 체크
                    subQueue.offer(new Location(nx, ny));
                    visit[ny][nx] = true;
                }

                if (queue.isEmpty()) {
                    // 우선순위 객체에 값이 저장되어 있다면 먹이를 발견했다는 뜻이므로
                    if (priority.x != N && priority.y != N) {
                        // 현재 위치를 바라보고 있는 위치로 이동한 후
                        currentLocation = priority;
                        // 이동한 만큼의 시간을 더해준 후
                        time += t;
                        // true를 리턴
                        return true;
                    }

                    // 만약에 subQueue에 아무 값이 없다면
                    if (subQueue.isEmpty()) {
                        break;
                    }

                    // 그렇지 않으면 queue와 스왑
                    // swap을 위한 tempQueue 생성
                    Queue<Location> tempQueue = queue;

                    queue = subQueue;
                    subQueue = tempQueue;
                    t++;
                }
            }
            // 다음 먹이를 찾지 못했을 경우 false를 리턴
            return false;
        }

        public void eat(int[][] map) {
            map[currentLocation.y][currentLocation.x] = 0;

            // 경험치를 채웠을 경우
            if (++exp == size) {
                // exp를 0으로 다시 바꾸고
                exp = 0;
                // size를 1 증가 시킨다.
                size++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int state = Integer.parseInt(st.nextToken());

                map[i][j] = state;
                // 만약 state가 9이면 상어 객체 생성
                if (state == 9) {
                    shark = new Shark(j, i);
                    map[i][j] = 0;
                }
            }
        }
        // 입력 끝
        while (shark.move(map)) {
            shark.eat(map);
        }

        System.out.println(shark.time);
    }
}
