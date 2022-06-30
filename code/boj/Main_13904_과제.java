package boj.gold;

import java.util.*;

public class Main_13904_과제 {
    static class Assignment implements Comparable<Assignment> {
        int deadline;
        int score;

        public Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            return o.deadline - deadline;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Assignment> assignments = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int deadline = sc.nextInt();
            int score = sc.nextInt();

            assignments.add(new Assignment(deadline, score));
        }

        Collections.sort(assignments);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int deadline = assignments.get(0).deadline;
        int result = 0;

        for (int i = deadline; i > 0; i--) {
            while (!assignments.isEmpty()) {
                Assignment current = assignments.get(0);

                if (current.deadline != i) break;

                pq.offer(current.score);
                assignments.remove(current);
            }

            if (!pq.isEmpty()) result += pq.poll();
        }

        System.out.println(result);
    }
}
