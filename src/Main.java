import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[i] = num;
        }

        dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = arr[1];

        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(solve(N));
    }

    public static int solve(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(solve(N-3) + arr[N-1] + arr[N], solve(N-2) + arr[N]);
        }

        return dp[N];
    }
}
