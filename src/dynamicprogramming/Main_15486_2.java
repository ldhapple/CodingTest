package dynamicprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15486_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] dp;

    static Consulting[] consultings;

    static class Consulting {
        public int day;
        public int cost;

        public Consulting(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        consultings = new Consulting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            consultings[i] = new Consulting(d, c);
        }


        dp = new int[N];
        Arrays.fill(dp, -1);

        System.out.println(bt(0));
    }

    public static int bt(int day) {
        if (day > N) {
            return -1000000000;
            //-100 안됨. 수가 작을 때 안되는 이유?
            //애매하게 빼주면 마지막에 Math.max 부분에서 애매하게 빼준 값이 선택될 수 있음.
            //선택이 아예 되면 안됨. 그때까지 일을 못하기 때문.
        }

        if (day == N) {
            return 0;
        }

        if (dp[day] != -1) return dp[day];
        //

        return dp[day] = Math.max(bt(day + consultings[day].day) + consultings[day].cost, bt(day + 1));
    }
}
