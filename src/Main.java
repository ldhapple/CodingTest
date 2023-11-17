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

    public static class Food {
        public int score;
        public int kcal;

        public Food(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //재료 수
            int L = Integer.parseInt(st.nextToken()); //제한 칼로리

            Food[] foods = new Food[N+1];
            int[][] dp = new int[N+1][L+1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    if (foods[i].kcal > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-foods[i].kcal] + foods[i].score);
                    }
                }
            }

            System.out.printf("#%d %d\n", test, dp[N][L]);
        }
    }
}
