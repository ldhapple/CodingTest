package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N][3]; //0 가로 1 세로 2 대각
        dp[0][1][0] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 2; x < N; x++) {
                if (map[y][x] != 0) continue;

                if (x-1 >= 0) {
                    dp[y][x][0] = dp[y][x-1][0] + dp[y][x-1][2];
                }

                if (y-1 >= 0) {
                    dp[y][x][1] = dp[y-1][x][1] + dp[y-1][x][2];
                }

                if (x-1 >= 0 && y-1 >= 0 && map[y-1][x] == 0 && map[y][x-1] == 0) {
                    dp[y][x][2] = dp[y-1][x-1][0] + dp[y-1][x-1][1] + dp[y-1][x-1][2];
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}
