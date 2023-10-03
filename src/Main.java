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

        int[] dp = new int[N+1];
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
            //i에서 어떤 제곱수를 빼면 dp[temp]가 나오고 그 제곱수를 다시 더하면 i이므로
            //1을 다시 더해주어야 함.
        }

        System.out.print(dp[N]);
    }
}
