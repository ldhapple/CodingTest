import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); //동전의 가지 수

            int[] coins = new int[N + 1];
            long[][] dp = new long[N+1][10001];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
                dp[i][coins[i]] += 1;
            }

            int target = Integer.parseInt(br.readLine()); //목표 금액

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j - coins[i] < 0) {
                        dp[i][j] = dp[i-1][j];
                        continue;
                    }
                    dp[i][j] += dp[i-1][j] + dp[i][j - coins[i]];
                }
            }

            System.out.println(dp[N][target]);
        }
    }
}
