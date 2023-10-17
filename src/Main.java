import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Subject {
        int hour;
        int score;

        public Subject(int hour, int score) {
            this.hour = hour;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //단원의 수
        int T = Integer.parseInt(st.nextToken()); //공부할 수 있는 시간

        Subject[] subjects = new Subject[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            subjects[i] = new Subject(h,s);
        }

        int[][] dp = new int[N+1][T+1]; //정답은 dp[N][T]

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (j - subjects[i].hour < 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - subjects[i].hour] + subjects[i].score);
            }
        }

        System.out.print(dp[N][T]);
    }
}
