package com.ssafy.live0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)

/**
 * @author taeheekim
 */
public class String_KMPTest {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] text = in.readLine().toCharArray();
        char[] pattern = in.readLine().toCharArray();

        int tLength = text.length, pLength = pattern.length;

        // 부분 일치 테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
        int[] pi = new int[pLength];

        // i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
        for (int i = 1, j = 0; i < pLength; i++) {
            // 이 코드... 필요한 건 알겠는데 어떤 원리로 동작하는지 모르겠다...
            // j > 0이라는 말은 결국 현재 바라보고 있는 지점의 직전까지는 접두사와 접미사가 같은 부분이 있었다는 뜻이 된다.
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        // i : 텍스트 포인터 , j: 패턴 포인터
        for (int i = 0, j = 0; i < tLength; ++i) {

            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) { //두 글자 일치
                if (j == pLength - 1) { // j가 패턴의 마지막 인덱스라면
                    cnt++; // 카운트 증가
                    list.add((i + 1) - pLength);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        if (cnt > 0) {
            System.out.println(list);
        }
    }
}