package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            list.add(i);
        }
        for (int i = 2; i <= 1000; i++) {
            int cur = i;
            // 현재 값의 배수로 나누어 떨어지지 않는 리스트를 다시 list에 대입
            if(list.contains(cur)){
                list = list.stream().filter(num -> num % cur != 0).collect(Collectors.toList());
                list.add(cur);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());

            // 만약 list에 cur이 포함된다면
            if (list.contains(cur)) {
                // 카운트를 1 증가 시킨 후
                count++;
            }
        }
        System.out.println(count);
    }
}
