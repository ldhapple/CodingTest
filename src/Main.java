import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MIN_VALUE;

            for (int j = 0; j * j <= i; j++) {
                int temp = i - (j * j);
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
        }
        System.out.println(dp[N-1]);
    }
}
