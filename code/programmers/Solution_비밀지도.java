package programmers.lv1;

public class Solution_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int cur1 = arr1[i];
            int cur2 = arr2[i];

            for (int j = 0; j < n; j++) {
                if ((cur1 & 1 << n - j - 1) != 0) map[i][j] = true;
                if ((cur2 & 1 << n - j - 1) != 0) map[i][j] = true;
            }
        }

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(map[i][j]) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
