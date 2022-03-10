package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1202_보석도둑 {

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
        PriorityQueue<Integer> bags = new PriorityQueue<>();

        // 보석 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewelries.offer(new Jewelry(weight, price));
        }

        // 가방 정보 입력
        for (int i = 0; i < K; i++) {
            bags.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (!bags.isEmpty()) {
            int curBag = bags.poll();

            // 가방이 견딜 수 있는 무게의 보석은 전부 pq에 담아놓는다.
            while (!jewelries.isEmpty()) {
                // 현재 보석의 무게가 가방이 견딜 수 있는 무게보다 높으면 가방에 넣지 못하므로 break
                if (jewelries.peek().weight <= curBag) {
                    pq.offer(jewelries.poll().price);
                } else break;
            }
            // 만약 pq에 값이 들어있으면 가장 높은 가치의 보석 하나를 빼내어 sum에 가치를 더한다.
            if (!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }
}
