package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_10026_적록색약 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getParentsIndex() {
            return r * N + c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 입력 값 배열
        char[][] map = new char[N][N];
        // 서로소 집합을 위한 parents 배열
        int[] parents = new int[N * N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        // 입력 끝

        // 서로소 집합을 만들기 위한 부모 초기화, 각각의 원소는 자기 자신을 가리키게 한다.
        init(parents);
        // 적록색약이 아닌 경우
        blindness(parents, map, 0);

        // 서로소 집합을 만들기 위한 부모 초기화, 각각의 원소는 자기 자신을 가리키게 한다.
        init(parents);
        // 적록색약인 경우
        blindness(parents, map, 1);

        System.out.println(sb);
    }

    // 서로소 집합 부모 초기화
    private static void init(int[] parents) {
        for (int i = 0; i < N * N; i++) {
            parents[i] = i;
        }
    }

    // a 그룹의 대장 찾기
    private static int find(int[] parents, int a) {
        // a가 자기 자신을 부모로 가리키고 있다면 자기 자신을 리턴
        if (parents[a] == a) return a;
        // 아니라면 부모를 찾은 후 부모 배열에 대입 후 그 값을 리턴
        return parents[a] = find(parents, parents[a]);
    }

    private static void union(int[] parents, int a, int b) {
        int ap = find(parents, a);
        int bp = find(parents, b);

        // a의 부모와 b의 부모가 같다면 바로 리턴
        if (ap == bp) return;

        // 그렇지 않으면 bp 그룹을 ap에 연결
        parents[bp] = ap;
    }

    // mode가 0이면 색약이 아닌 경우이고 1이면 색약인 경우이다.
    private static void blindness(int[] parents, char[][] map, int mode) {
        // bfs를 위한 큐
        Queue<Location> queue = new LinkedList<>();

        // 방문 내역
        boolean[][] visit = new boolean[N][N];

        // 상, 우, 좌, 하
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, 1, -1, 0};

        // (0, 0)부터 (N-1, N-1)까지 방문하지 않은 원소 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 만약 방문했다면?
                if (visit[i][j]) continue;

                // 현재 위치를 큐에 넣고, (cr, cc) 방문 체크 (초기값 0, 0)
                queue.offer(new Location(i, j));
                visit[i][j] = true;

                // 현재 위치를 기점으로 bfs 알고리즘 실행
                while (!queue.isEmpty()) {
                    // 현재 위치 방문
                    Location cur = queue.poll();

                    // 현재 위치의 문자
                    char currentCharactor = map[cur.r][cur.c];

                    switch (mode) {
                        /**
                         * 적록색약이 아닐 경우에는 경우의 수가
                         * R, G, B 3개로 다 나누어야 한다.
                         */
                        case 0:
                            for (int k = 0; k < 4; k++) {
                                // 다음 위치
                                int nr = cur.r + dr[k];
                                int nc = cur.c + dc[k];

                                // 다음 위치가 배열의 범위를 벗어났다면
                                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                                // 다음 위치가 이미 방문한 위치라면
                                if (visit[nr][nc]) continue;

                                // 현재 위치와 다음 위치의 문자가 다르다면
                                if(currentCharactor != map[nr][nc]) continue;

                                // 다 통과하면
                                Location next = new Location(nr, nc);

                                // 큐에 다음 위치를 넣고 똑같은 부모로 맞춰준 후 다음 위치 방문 체크를 한다.
                                queue.offer(next);
                                union(parents, cur.getParentsIndex(), next.getParentsIndex());
                                visit[nr][nc] = true;
                            }
                            break;

                        /**
                         * 적록색약일 경우에는 경우의 수가
                         * 현재 위치가 B일 경우와 B가 아닐 경우로 나뉜다.
                         */
                        case 1:
                            for (int k = 0; k < 4; k++) {
                                // 다음 위치
                                int nr = cur.r + dr[k];
                                int nc = cur.c + dc[k];

                                // 다음 위치가 배열의 범위를 벗어났다면
                                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                                // 다음 위치가 이미 방문한 위치라면
                                if (visit[nr][nc]) continue;

                                // 현재 위치가 B인 경우 다음 위치가 B라면 큐에 넣는다.
                                if (currentCharactor == 'B') {
                                    // 다음 위치가 B가 아니면 continue
                                    if (map[nr][nc] != 'B') continue;
                                }
                                // 현재 위치가 B가 아닐 경우 다음 위치가 B가 아닐 때 큐에 넣는다.
                                else {
                                    // 다음 위치가 B이면 continue;
                                    if (map[nr][nc] == 'B') continue;
                                }

                                // 만약 현재 위치가 다음 위치와 똑같은 알파벳을 가지고 있다면(적록색약일 경우에는 R과 G를 똑같은 알파벳으로 본다)
                                Location next = new Location(nr, nc);

                                // 큐에 다음 위치를 넣고 똑같은 부모로 맞춰준 후 다음 위치 방문 체크를 한다.
                                queue.offer(next);
                                union(parents, cur.getParentsIndex(), next.getParentsIndex());
                                visit[nr][nc] = true;
                            }
                            break;
                    }
                }
            }
        }
        Set<Integer> blindSet = new HashSet<>();

        for (int i = 0; i < N * N; i++) {
            blindSet.add(parents[i]);
        }

        sb.append(blindSet.size()).append(" ");
    }
}
