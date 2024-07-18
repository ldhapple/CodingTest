package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static class Consulting {
        public int day;
        public int cost;

        public Consulting(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        Consulting[] consultings = new Consulting[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            consultings[i] = new Consulting(day, cost);
        }

        consultings[N + 1] = new Consulting(0, 0);
        int[] dp = new int[N + 2];

        int max = 0;

        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]); //i까지의 최대 이익 중 최대라면 그 i일까지의 선택이 최선의 선택.

            Consulting plan = consultings[i];
            int nextDay = i + plan.day;

            if (nextDay < N + 2) {
                dp[nextDay] = Math.max(dp[nextDay], max + plan.cost);
            }
        }

        System.out.print(dp[N + 1]);
    }
}


