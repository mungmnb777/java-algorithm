package boj.gold;

import java.util.Scanner;

public class Main_14719_빗물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        int[] arr = new int[W];

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < W; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        int currentHeight = 0;
        int result = 0;

        for (int i = 0; i < maxIndex; i++) {
            if (arr[i] >= currentHeight) currentHeight = arr[i];
            else {
                result += currentHeight - arr[i];
            }
        }

        currentHeight = 0;

        for (int i = W - 1; i > maxIndex; i--) {
            if (arr[i] >= currentHeight) currentHeight = arr[i];
            else {
                result += currentHeight - arr[i];
            }
        }

        System.out.println(result);
    }
}
