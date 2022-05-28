package programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_튜플 {

    private static List<List<Integer>> list = new ArrayList<>();

    public int[] solution(String s) {
        init(s);
        return result();
    }

    private static void init(String s) {
        String temp = s.substring(1, s.length() - 1);
        StringBuilder element = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);

            if (c == '{') element.setLength(0);
            else if (c == '}') parse(element.toString());
            else element.append(c);
        }

        // 원소의 개수로 정렬
        list.sort(Comparator.comparingInt(List::size));
    }

    private static void parse(String element) {
        list.add(Arrays.stream(element.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    private static int[] result() {
        Set<Integer> result = new HashSet<>();

        for (List<Integer> integers : list) {
            for (Integer i : integers) {
                if (!result.contains(i)) result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
