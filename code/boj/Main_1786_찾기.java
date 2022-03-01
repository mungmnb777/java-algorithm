package boj.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        // 부분 일치 테이블
        int[] pi = new int[pattern.length];

        // pattern에서 부분 일치 테이블 만들기
        for (int header = 0, footer = 1; footer < pattern.length; footer++) {
            // header가 0보다 크다는 건 이전까지는 접두사, 접미사가 있었다는 뜻이다.
            // header가 0보다 크고 현재 header와 footer가 가리키는 값이 다르면 header 포인터를 pi[header - 1]의 위치로 옮긴다.
            while (header > 0 && pattern[header] != pattern[footer]) header = pi[header - 1];

            // header와 footer가 가리키는 값이 같으면 부분 일치 테이블에 header에 1을 더한 값을 넣는다.
            if (pattern[header] == pattern[footer]) pi[footer] = ++header;
                // 아니면 0을 넣는다.
            else pi[footer] = 0;
        }

        int cnt = 0;
        List<Integer> pos = new ArrayList<>();

        // tp는 text pointer, pp는 pattern pointer
        for (int tp = 0, pp = 0; tp < text.length; tp++) {
            // 만약 pp가 0보다 크고 현재 tp가 가리키고 있는 text의 문자와 pp가 가리키고 있는 pattern의 문자가 다른 경우 pp를 옮겨준다.
            while (pp > 0 && text[tp] != pattern[pp]) pp = pi[pp - 1];
            // tp 문자와 pp 문자가 같으면
            if (text[tp] == pattern[pp]) {
                // pattern의 끝까지 다 같은 경우 원하는 문자열의 위치를 찾은 것이므로
                if (pp == pattern.length - 1) {
                    // 찾은 문자열의 개수를 1 증가시키고
                    cnt++;
                    // 찾은 문자열의 시작 위치를 저장한 후
                    pos.add(tp - pattern.length + 2);
                    // 그 이후에도 같은 문자열이 있는지 찾기 위해 접두사 다음 위치로 pp를 점프한다.
                    pp = pi[pp];
                } else {
                    pp++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append("\n");

        for (Integer po : pos) {
            sb.append(po).append(" ");
        }

        System.out.println(sb);
    }
}
