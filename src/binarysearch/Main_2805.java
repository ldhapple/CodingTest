package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //나무의 수
        int M = Integer.parseInt(st.nextToken()); //원하는 나무 길이

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long answer = 0;
        int min = 1;
        int max = trees[N - 1];
        int mid = 0;
        long total = 0;

        while (min <= max) {
            total = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) {
                    total += trees[i] - mid;
                }
            }

            if (total < M) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
