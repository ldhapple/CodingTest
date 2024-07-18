package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] lineLen;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lineLen = new int[K];

        long max = 0;
        long min = 0;
        long mid = 0;

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            lineLen[i] = num;

            max = Math.max(max, num);
        }

        long cnt;
        long answer = Integer.MIN_VALUE;

        while (min < max) {
            cnt = 0;

            mid = (min + max) / 2; //이분탐색 문제는 구하고자 하는 값이 mid가 되어야 함.

            for (int i = 0; i < K; i++) {
                cnt += (lineLen[i] / mid); // 처음에 제일 긴 길이의 중간값으로 자르는데 안잘려서 0이면? => 기존 가지고 있던 랜선의 수보다 더 작은걸 요구할리 없다.
            }

            if (cnt < N) { //잘린 랜선의 개수가 원하는 랜선 개수보다 낮으면 더 작은 길이로 잘라야 함.
                max = mid;
            } else {
                min = mid + 1; // 0 -> mid + 1 더 긴 길이로 자르게 됨.
            }
        }

        System.out.print(min - 1);
    }
}
