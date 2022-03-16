package com.ssafy.ws0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
    static int L, V, max;

    static class Node {
        int data;
        Node link;

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            L = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            max = 0;

            st = new StringTokenizer(br.readLine(), " ");

            Node[] adjList = new Node[101];

            for (int i = 0; i < L / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjList[from] = new Node(to, adjList[from]);
            }

            // 입력 끝
            bfs(adjList, V);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Node[] adjList, int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 깊이
        int[] depth = new int[101];

        // 탐색한 그래프의 최대 깊이
        int depthSize = 0;

        // 방문 내역
        boolean[] visit = new boolean[101];

        // 처음 시작 지점을 큐에 넣는다.
        queue.offer(start);

        // 처음엔 깊이를 1로 설정
        depth[start] = 1;

        // 방문 예정이므로 방문 체크
        visit[start] = true;


        while (!queue.isEmpty()) {
            // 큐에서 꺼내 노드 방문
            int cur = queue.poll();

            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if (!visit[temp.data]) {
                    // 방문할 예정인 노드를 큐에 넣는다.
                    queue.offer(temp.data);
                    // 방문할 예정인 노드의 깊이를 체크한다.
                    depth[temp.data] = depth[cur] + 1;
                    // 깊이 사이즈도 저장한다.
                    depthSize = Math.max(depthSize, depth[temp.data]);
                    // 방문할 예정인 노드를 방문했다고 가정하고 체크한다.
                    visit[temp.data] = true;
                }
            }
        }

        for (int i = 0; i < depth.length; i++) {
            if (depth[i] == depthSize) max = Math.max(max, i);
        }
    }
}
