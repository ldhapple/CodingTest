package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Temp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        // i - 1까지의 길이가 채워져 있는 경우 (2x1 1개를 추가하는 1가지 경우 뿐)
        // i - 2까지의 길이가 채워져 있는 경우 (1x2 덮개 2개 사용하는 경우 / 2x2 덮개 하나 사용하는 경우 이 2가지)
        // (2x1 덮개가 못들어가는 이유는 i - 1까지 채워진 경우에서 이미 체크)
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }

        System.out.println(dp[N] % 796796);
    }
}
