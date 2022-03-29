package boj.silver.pcspractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15663_N과M_9 {
    static int N, M;
    static int[] input, numbers;
    static Set<String> set = new LinkedHashSet<>();
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        numbers = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        permutation(0);

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void permutation(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            set.add(sb.toString());
            sb.setLength(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            numbers[cnt] = input[i];
            visit[i] = true;
            permutation(cnt + 1);
            visit[i] = false;
        }
    }
}
