import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    public static class City {
        public int cost;
        public int customer;

        public City(int cost, int customer) {
            this.cost = cost;
            this.customer = customer;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //동전 종류
        int k = Integer.parseInt(st.nextToken()); //합이 k

        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            for (int j = money; j < k + 1; j++) {
                dp[j] += dp[j - money];
            }
        }

        System.out.println(dp[k]);
    }
}
