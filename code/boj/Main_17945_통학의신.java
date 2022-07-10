package boj.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17945_통학의신 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double A = sc.nextDouble();
        double B = sc.nextDouble();

        double pow = Math.pow(A, 2);

        double[] ans = new double[2];

        ans[0] = (0 - A) + Math.sqrt(pow - B);
        ans[1] = (0 - A) - Math.sqrt(pow - B);

        Arrays.sort(ans);

        if (ans[0] == ans[1]) System.out.println((int) ans[1]);
        else System.out.println((int) ans[0] + " " + (int) ans[1]);
    }
}
