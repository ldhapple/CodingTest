import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Stone {
        int s_jump;
        int b_jump;

        public Stone(int s_jump, int b_jump) {
            this.s_jump = s_jump;
            this.b_jump = b_jump;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stone[] stones = new Stone[N-1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            stones[i] = new Stone(s, b);
        }

        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 10000);
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = stones[0].s_jump;
        dp[1][1] = 0;
        dp[2][0] = stones[0].b_jump;
        dp[3][0] = Math.min(dp[2][0] + stones[0].b_jump, dp[0][0] + stones[1].s_jump);

        for (int i = 4; i < N; i++) {
            dp[i][0] = Math.min(dp[i-2][0] + stones[i-2].b_jump, dp[i-1][0] + stones[i-1].s_jump);
            dp[i][1] = Math.min(Math.min(dp[i-1][1] + stones[i-1].s_jump, dp[i-2][1] + stones[i-2].b_jump), dp[i-3][0] + k);
        }

        System.out.print(Math.min(dp[N-1][0], dp[N-1][1]));
    }
}
