package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int[] parent;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점의 수
        int V = Integer.parseInt(st.nextToken());
        // 간선의 수
        int E = Integer.parseInt(st.nextToken());
        // 간선 리스트
        parent = new int[V];
        edgeList = new Edge[E];
        // 서로소 집합 부모 리스트 초기화
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(from, to, weight);
        }

        // 배열 정렬
        Arrays.sort(edgeList);

        int result = 0;

        // 입력 끝
        for (int i = 0; i < E; i++) {
            int from = edgeList[i].from;
            int to = edgeList[i].to;
            int weight = edgeList[i].weight;

            if (union(from - 1, to - 1)) {
                result += weight;
            }
        }

        System.out.println(result);
    }

    private static int find(int a) {
        // 만약 a의 부모가 자기 자신이라면
        if (a == parent[a]) return a;
        // 그렇지 않으면 부모를 찾아 parent[a]에 넣은 후 리턴
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        // ap와 bp가 같다면 합치기 실패
        if (ap == bp) return false;

        // 그렇지 않으면
        parent[bp] = ap;
        return true;
    }
}
