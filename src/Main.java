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

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //돌의 개수
        int K = Integer.parseInt(st.nextToken()); //최대 힘

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1001);

        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                int power = power(j, i, arr);

                if (power <= K && dp[j] != -1) {
                    flag = true;
                    dp[i] = Math.min(dp[i], dp[j] + power);
                }
            }
            if (!flag) {
                dp[i] = -1;
            }
        }

        if (dp[N-1] != -1) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    public static int power(int start, int fin, int[] arr) {
        return (fin - start) * (1 + Math.abs(arr[start] - arr[fin]));
    }
}
