import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //퇴사까지 남은 날짜

        int[][] arr = new int[2][N + 2];
        int[] dp = new int[N + 2];

        for (int j = 1; j < N + 1; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 1; i <= N + 1; i++) {

//            max = Math.max(max, dp[i]);

            int next = i + arr[0][i];

            if (next < N + 2) {
                dp[next] = Math.max(dp[next], dp[i] + arr[1][i]);
                System.out.println("next=" + next + " " + dp[next]);
            }
        }

        System.out.println(dp[N+1]);
    }
}
