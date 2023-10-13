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

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N-1][21];
        dp[0][arr[0]] = 1; //첫 숫자 처리.

        /**
         * dp[{1}][{2}] 에서
         * {1}은 사용한 숫자의 개수
         * {2}는 {1} 개수의 숫자 연산으로 0~20까지의 경우의 수
         * -를 넣은 경우와
         * +를 넣은 경우를 if문으로 나누어 각 dp배열에 더해준다.
         */

        for (int i = 1; i < N - 1; i++) {
            for (int num = 0; num <= 20; num++) {
                if (num - arr[i] >= 0) {
                    dp[i][num] += dp[i-1][num-arr[i]];
                }

                if (num+arr[i] <= 20) {
                    dp[i][num] += dp[i-1][num+arr[i]];
                }
            }
        }

        System.out.print(dp[N-2][arr[N-1]]);
    }
}
