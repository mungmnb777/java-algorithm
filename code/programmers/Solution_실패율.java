package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_실패율 {
    static class Stage implements Comparable<Stage> {
        int num;
        int arrivalCount;
        int failureCount;

        public Stage(int num, int arrivalCount, int failureCount) {
            this.num = num;
            this.arrivalCount = arrivalCount;
            this.failureCount = failureCount;
        }

        private float getFailureRate() {
            if (arrivalCount == 0) return 0;
            return (float) failureCount / arrivalCount;
        }

        @Override
        public int compareTo(Stage o) {

            int result = Float.compare(o.getFailureRate(), getFailureRate());

            return result == 0 ? num - o.num : result;
        }
    }

    public int[] solution(int N, int[] stages) {

        Stage[] array = new Stage[N + 2];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Stage(i, 0, 0);
        }

        for (int stage : stages) {
            for (int i = stage; i >= 1; i--) {
                array[i].arrivalCount++;
            }
            array[stage].failureCount++;
        }

        Arrays.sort(array);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N + 2; i++) {
            if (array[i].num == 0 || array[i].num == N + 1) continue;
            list.add(array[i].num);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
