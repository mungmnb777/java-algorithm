package boj.bronze;

import java.util.Scanner;

public class Main_6131_완전제곱수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                if (i * i == j * j + N) count++;
            }
        }

        System.out.println(count);
    }
}
