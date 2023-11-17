import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Point {
        public int y;
        public int x;
        public int sum;

        public Point(int y, int x, int sum) {
            this.y = y;
            this.x = x;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());

            int[][] table = new int[N][N];
            int[][] dp = new int[N + 1][N + 1];
            int[] dy = {1,-1,0,0};
            int[] dx = {0,0,1,-1};

            for (int i = 0; i < N; i++) {
                String numbers = br.readLine();
                for (int j = 0; j < N; j++) {
                    table[i][j] = numbers.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            dp[0][0] = table[0][0];

            PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);
            pq.add(new Point(0,0,0));

            while(!pq.isEmpty()) {
                Point cur = pq.poll();

                if (cur.sum > dp[cur.y][cur.x]) continue;

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N) continue;

                    int nextSum = cur.sum + table[ny][nx];

                    if (nextSum < dp[ny][nx]) {
                        dp[ny][nx] = nextSum;
                        pq.add(new Point(ny, nx, nextSum));
                    }
                }
            }

            System.out.printf("#%d %d\n", test, dp[N-1][N-1]);
        }
    }
}
