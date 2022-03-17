package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
    static int N;

    static class Store {
        int zero;
        int one;

        public Store(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            Store[] store = new Store[N + 1];

            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    store[j] = new Store(1, 0);
                } else if (j == 1) {
                    store[j] = new Store(0, 1);
                } else {
                    int currentZero = store[j - 2].zero + store[j - 1].zero;
                    int currentOne = store[j - 2].one + store[j - 1].one;

                    store[j] = new Store(currentZero, currentOne);
                }
            }

            System.out.println(store[N].zero + " " + store[N].one);
        }
    }
}
