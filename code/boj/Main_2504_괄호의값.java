package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2504_괄호의값 {
    // 현재 인덱스 위치
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 검증용 스택
        Stack<Character> stack = new Stack<>();
        // 저장된 스트링
        String bracketBox = br.readLine();
        // 청크의 개수
        int chunk = 0;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');

        // 테스트 케이스 검증 및 청크 개수 저장
        for (int i = 0; i < bracketBox.length(); i++) {
            char curBracket = bracketBox.charAt(i);
            if (curBracket == '(' || curBracket == '[') {
                stack.push(curBracket);
            } else {
                // 스택이 비어있으면 0을 출력 후 리턴
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                // 스택에서 빼내온 값이 현재 괄호와 매칭되는 char가 아니면 0을 출력 후 리턴
                if(stack.pop() != map.get(curBracket)){
                    System.out.println(0);
                    return;
                }
            }
            if(stack.isEmpty()) {
                chunk++;
            }
        }

        // 청크 단위 결과값 저장
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chunk; i++) {
            list.add(calculateChunk(bracketBox));
        }

        System.out.println(list.stream().mapToInt(i -> i).sum());
    }

    // 청크별로 연산하기 위해 만듦
    private static int calculateChunk(String bracketBox) {
        char curBracket = bracketBox.charAt(index++);
        if (curBracket == '(' || curBracket == '[') {
            return calc(bracketBox);
        } else {
            return 0;
        }
    }

    // 괄호 연산 하는 부분
    private static int calc(String bracketBox) {
        // 괄호 안의 값을 저장할 리스트
        List<Integer> list = new ArrayList<>();

        while (true) {
            // 현재 인덱스의 값 저장 (초기값 0부터 1씩 증가)
            char curBracket = bracketBox.charAt(index++);

            if (curBracket == ')' || curBracket == ']') {
                if (!list.isEmpty()) {
                    return list.stream().mapToInt(i -> i).sum() * getNumberByBracket(curBracket);
                } else {
                    return getNumberByBracket(curBracket);
                }
            }
            list.add(calc(bracketBox));
        }
    }

    // 괄호가 닫힐 경우 ()이면 2를 반환하고 []이면 3을 반환하는 메서드
    private static int getNumberByBracket(char c) {
        if (c == ')') return 2;
        if (c == ']') return 3;
        else return 0;
    }
}
