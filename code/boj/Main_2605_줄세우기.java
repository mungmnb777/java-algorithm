package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        // 학생 정보 담을 스택
        Stack<Integer> stack = new Stack<>();

        // 임시 리스트
        Stack<Integer> temp = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수
        int studentCount = Integer.parseInt(br.readLine());

        // 뽑게될 번호
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 학생들 줄 서기 시작
        for (int i = 1; i <= studentCount; i++) {
            // 뽑은 번호
            int num = Integer.parseInt(st.nextToken());
            while (stack.size() - num > 0) {
                temp.push(stack.pop());
            }
            stack.push(i);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);

        br.close();
    }
}
