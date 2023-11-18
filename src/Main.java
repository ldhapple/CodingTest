import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 돌의 개수
        int K = Integer.parseInt(st.nextToken()); // 쓸 수 있는 최대 힘

        int[] bridge = new int[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1001);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            boolean flag = false;
            for (int j = 1; j < i; j++) {
                int power = getPower(j, i, bridge);

                if (power <= K && dp[j] != -1) {
                    flag = true;
                    dp[i] = Math.min(dp[i], dp[j] + power);
                }
            }
            if (!flag) {
                dp[i] = -1;
            }
        }

        for (int i : dp) {
            System.out.println(i);
        }

        if (dp[N] != -1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int getPower(int i, int j, int[] bridge) {
        return (j-i) * (1 + Math.abs(bridge[i] - bridge[j]));
    }
}
