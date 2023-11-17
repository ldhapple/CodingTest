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

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());

            int[] stockPrices = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stockPrices[i] = Integer.parseInt(st.nextToken());
            }

            int start = N-1;
            int end = N-1;

            long totalProfit = 0;

            while (end > -1) {
                int buyPrice = stockPrices[end];
                int sellPrice = stockPrices[start];

                if (buyPrice > sellPrice) {
                    for (int i = start; i > end; i--) {
                        totalProfit += sellPrice - stockPrices[i];
                    }
                    start = end;
                }

                if (end == 0) {
                    for (int i = start; i >= end; i--) {
                        totalProfit += sellPrice - stockPrices[i];
                    }
                }

                end--;
            }

            if (totalProfit < 0) {
                totalProfit = 0;
            }

            System.out.printf("#%d %d\n", test, totalProfit);
        }
    }
}
