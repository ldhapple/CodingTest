package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Arrays.sort(list);

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(list, Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int binarySearch(int[] arr, int targetVal) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = arr[mid];

            if (midValue == targetVal) return 1;

            if (midValue < targetVal) {
                start = mid + 1;
            } else if (midValue > targetVal) {
                end = mid - 1;
            }
        }

        return 0;
    }
}
