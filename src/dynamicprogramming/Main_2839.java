package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2839 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 5000);

        if (N >= 3) {
            dp[3] = 1;
        }

        if (N >= 5) {
            dp[5] = 1;
        }


        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        if (dp[N] == 5000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
