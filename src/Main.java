import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Coin {
        int value;
        int cnt;

        public Coin(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //지폐의 금액
        int K = Integer.parseInt(br.readLine()); //동전의 가지 수
        int[][] dp = new int[K+1][T+1];

        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(new Coin(0,0));
        for (int i = 1; i <= K; i++) {
            dp[i-1][0] = 1; //0을 만드는 개수 1로 초기화

            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); //금액
            int n = Integer.parseInt(st.nextToken()); //개수

            coins.add(new Coin(p, n));
        }

        for (int i = 1; i <= K; i++) {
            Coin coin = coins.get(i);
            for (int j = 1; j <= T; j++) {
                for(int m = 0; m <= coin.cnt && m*coin.value <= j; m++) {
                    dp[i][j] += dp[i-1][j - m*coin.value];
                }
            }
        }

        System.out.print(dp[K][T]);
    }
}
