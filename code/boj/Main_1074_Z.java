package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	// 분할 정복으로 줄여가며 각 사분면의 첫번째 요소 위치를 저장할 변수
	static int position;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 지수 -> 2^N승이 배열의 가로 세로 길이가 된다.
		int N = Integer.parseInt(st.nextToken());
		// 행
		int r = Integer.parseInt(st.nextToken());
		// 열
		int c = Integer.parseInt(st.nextToken());
		
		// r행과 c열의 위치를 몇 번쨰로 방문하는지 구현하는 메서드
		find(N, r, c);
		
		System.out.println(position);
	}
	
	/**
	 * 재귀 함수로 구현하였다.
	 * 처음 2^N * 2^N 사이즈의 배열에서 사분면으로 나눈다.
	 * 그 후 입력 받은 r과 c가 어느 사분면에 위치하는지 확인한다.
	 * 그 사분면의 첫번째 요소에 해당하는 값을 position에 더해준다.
	 * 해당하는 사분면으로 배열의 범위를 조정한 후 위의 메서드를 반복한다.
	 * N이 0이 되는 경우(배열의 크기가 1이 되는 경우) 재귀 호출을 빠져나온다.
	 */
	static void find(int N, int r, int c) {
		// 큰 블럭의 가로 세로 길이
		int size = 1 << N;
		// 큰 블럭을 4개로 나눈 작은 블럭 넓이
		int block = size * size / 4;

		if (N == 0) {
			return;
		}

		// 1사분면
		if (r < size / 2 && c < size / 2) {
			find(N - 1, r, c);
			
		// 2사분면
		} else if (r < size / 2 && c >= size / 2) {
			position += block * 1;
			find(N - 1, r, c - size / 2);
			
		// 3사분면
		} else if (r >= size / 2 && c < size / 2) {
			position += block * 2;
			find(N - 1, r - size / 2, c);
			
		// 4사분면
		} else if (r >= size / 2 && c >= size / 2) {
			position += block * 3;
			find(N - 1, r - size / 2, c - size / 2);
		}
	}
}
