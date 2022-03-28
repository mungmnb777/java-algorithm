package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스위치 개수
        int N = Integer.parseInt(br.readLine());

        boolean[] sch = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            char ch = st.nextToken().charAt(0);
            if (ch == '1') {
                sch[i] = true;
            }
        }

        // 학생 수
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int gender = Integer.parseInt(st.nextToken());
            int card = Integer.parseInt(st.nextToken());

            switch (gender) {
                case 1:
                    int temp = card;
                    while (card <= N) {
                        sch[card] = !sch[card];
                        card += temp;
                    }
                    break;
                case 2:
                    sch[card] = !sch[card];

                    int left = card - 1;
                    int right = card + 1;

                    if (left < 1 || right > N) {
                        break;
                    }

                    while (sch[left] == sch[right]) {
                        sch[left] = !sch[left--];
                        sch[right] = !sch[right++];
                        if (left < 1 || right > N) {
                            break;
                        }
                    }
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (sch[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
            if (i % 20 == 0) {
                System.out.println(sb);
                sb.setLength(0);
            }
        }
        System.out.println(sb);
    }
}

/*
21
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1
1 3
*/
