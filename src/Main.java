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

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        /**
         * dp[1] = 1이 K개의 숫자 합으로 만들어지는 개수
         * 숫자의 중복이 가능하다.
         * N이 1이고, K가 2라면
         * 0부터이기 떄문에 (0,1), (1,0) 2가지의 경우가 있다.
         */

        int[][] dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000000;
            }
        }

        System.out.print(dp[K][N]);
    }
}
