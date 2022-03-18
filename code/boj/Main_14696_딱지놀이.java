package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Kid {
    int star = 0;
    int circle = 0;
    int rectangle = 0;
    int triangle = 0;

    // 4면 별, 3이면 동그라미, 2면 네모, 1이면 세모
    public void add(int card) {
        switch (card) {
            case 1:
                triangle++;
                break;
            case 2:
                rectangle++;
                break;
            case 3:
                circle++;
                break;
            case 4:
                star++;
                break;
        }
    }

    public void clear() {
        star = 0;
        circle = 0;
        rectangle = 0;
        triangle = 0;
    }
}

public class Main_14696_딱지놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 딱지 놀이의 총 라운드 수 N
        final int N = Integer.parseInt(br.readLine());

        Kid A = new Kid();
        Kid B = new Kid();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            A.clear();
            B.clear();

            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            // A 딱지의 그림
            while (st.hasMoreTokens()) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            // B 딱지의 그림
            while (st.hasMoreTokens()) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            // A와 B 비교
            if (A.star > B.star) {
                System.out.println('A');
                continue;
            } else if (A.star < B.star) {
                System.out.println('B');
                continue;
            }

            if (A.circle > B.circle) {
                System.out.println('A');
                continue;
            } else if (A.circle < B.circle) {
                System.out.println('B');
                continue;
            }

            if (A.rectangle > B.rectangle) {
                System.out.println('A');
                continue;
            } else if (A.rectangle < B.rectangle) {
                System.out.println('B');
                continue;
            }

            if (A.triangle > B.triangle) {
                System.out.println('A');
                continue;
            } else if (A.triangle < B.triangle) {
                System.out.println('B');
                continue;
            }

            System.out.println('D');
        }
    }
}
