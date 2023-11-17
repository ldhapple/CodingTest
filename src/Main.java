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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // N*N 크기의 배열
            int M = Integer.parseInt(st.nextToken()); // M*M 사이즈의 크기 파리채

            int[][] fly = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    answer = Math.max(answer, func(fly, i, j, M));
                }
            }

            System.out.printf("#%d %d\n", test+1, answer);
        }
    }

    private static int func(int[][] fly, int i, int j, int M) {
        int total = 0;
        for (int a = i; a < i + M; a++) {
            for (int b = j; b < j + M; b++) {
                total += fly[a][b];
            }
        }

        return total;
    }
}
