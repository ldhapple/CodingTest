package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Bag {
        public int weight;
        public int value;

        public Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //물건의 개수
        int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        Bag[] bags = new Bag[N + 1];
        bags[0] = new Bag(0, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bags[i] = new Bag(w, v);
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (bags[i].weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bags[i].weight] + bags[i].value);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
