import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            //첫번째 자리 수는 다음 자리수가 없으므로 경우의 수가 1가지 뿐이다.
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
            //dp[N][i] 는 N자리 수가 i인 수.
        }

        System.out.print(result % 1000000000);
    }

    static long recur(int digit, int val) {

        // digit = 자릿수, 654323 이라면 6자리수이고, 6번째 자리수는 6, digit이 1인 수는 3.
        // 첫째 자리수에 도착하면 탐색할 필요 없음.
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                //0인 경우 다음 자리 수는 무조건 1이 와야 함.
                dp[digit][val] = recur(digit-1, 1);
            } else if (val == 9) {
                //9인 경우 다음 자리수는 무조건 8이 와야 함.
                dp[digit][val] = recur(digit-1, 8);
            } else {
                /**
                 * N==2라고 해보자.
                 * 2x 인 수 중에 계단 수 이기 위해서는 1 or 3이 와야 한다.
                 * N==3 에서 digit이 2로 온다고 하면, 3xx -> 3 + (2 or 1) + (1,3 or 0) 이런 흐름.
                 */
                dp[digit][val] = recur(digit-1, val-1) + recur(digit-1, val+1);
            }
        }

        return dp[digit][val] % 1000000000;
    }
}
