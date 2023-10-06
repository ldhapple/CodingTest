import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.print(dfs(0,0, table, dp));
    }

    public static long dfs(int x, int y, int[][] table, long[][] dp) {
        int size = table.length - 1;

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == size && y == size) {
            return 1;
        }

        dp[x][y] = 0;

        int dx = x + table[x][y];
        int dy = y + table[x][y];

        if (dx >= size && dy >= size) {
            return 0;
        }

        if (dx < size) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x + table[x][y], y, table, dp));
        }

        if (dy < size) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x, y + table[x][y], table, dp));
        }

        return dp[x][y];
    }
}
