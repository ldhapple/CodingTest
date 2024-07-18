package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = N - 1;

        long closeZeroValue = Long.MAX_VALUE;
        int result_start = 0;
        int result_end = 0;

        while (start < end) {
            long sum = arr[start] + arr[end];

            if (sum == 0) {
                result_start = start;
                result_end = end;
                break;
            }

            if (sum < 0) {
                if (closeZeroValue > Math.abs(sum)) {
                    closeZeroValue = Math.min(closeZeroValue, Math.abs(sum));
                    result_start = start;
                    result_end = end;
                }

                start++;
            } else if (sum > 0) {
                if (closeZeroValue > Math.abs(sum)) {
                    closeZeroValue = Math.min(closeZeroValue, Math.abs(sum));
                    result_start = start;
                    result_end = end;
                }
                end--;
            }
        }

        System.out.print(arr[result_start] + " " + arr[result_end]);
    }
}
