package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main_3985_롤케이크 {
    static class Person {
        int from;
        int to;
        int expect;

        public Person(int from, int to) {
            this.from = from;
            this.to = to;
            this.expect = to - from + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] cake = new int[L + 1];
        // 1번부터 번호를 줄거기 떄문에 N 사이즈를 하나 늘림
        Person[] people = new Person[N + 1];
        int expectMax = 0;
        int expectMaxIndex = 0;

        // 1번부터 시작
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (expectMax < people[i].expect) {
                expectMax = people[i].expect;
                expectMaxIndex = i;
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = people[i].from; j <= people[i].to; j++) {
                cake[j] = i;
            }
        }

        int[] count = new int[N + 1];
        for (int i = 1; i <= L; i++) {
            count[cake[i]]++;
        }

        int realMax = 0;
        int realMaxIndex = 0;

        for (int i = 1; i <= N; i++) {
            if (realMax < count[i]) {
                realMax = count[i];
                realMaxIndex = i;
            }
        }

        System.out.println(expectMaxIndex);
        System.out.println(realMaxIndex);
    }
}
