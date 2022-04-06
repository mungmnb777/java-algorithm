package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_다트게임 {

    public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int[] score = new int[3];

        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);

        int index = 0;
        String temp = "";

        for (int i = 0; i < dartResult.length(); i++) {
            // 현재 char 값
            char cur = dartResult.charAt(i);

            if (map.containsKey(cur)) {
                int tempScore = Integer.parseInt(temp);
                score[index++] = (int) Math.pow(tempScore, map.get(cur));
            } else if (cur == '*' || cur == '#') {
                option(score, index - 1, cur);
            } else {
                temp += cur;
                continue;
            }
            temp = "";
        }

        return Arrays.stream(score).sum();
    }

    private static void option(int[] score, int index, char mode) {
        switch (mode) {
            case '*':
                if (index != 0) score[index - 1] *= 2;
                score[index] *= 2;
                break;
            case '#':
                score[index] *= -1;
                break;
        }
    }
}
