import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class State {
        int weight;
        int value;

        public State(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        State[] arr = new State[N+1];
        arr[0] = new State(0,0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new State(w, v);
        }

        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            /**
             * i번 물건까지의 무게별 최대 가치의 합을 찾았다면
             * 이후 어떤 물건이 와도, 이전 물건의 조합에 변경이 있을 수 없다.
             * 따라서 i=물건별 순회
             * j = 무게별 순회
             */

            for (int j = 1; j <= K; j++) {
                if (arr[i].weight > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].weight] + arr[i].value);
                }
            }
        }
        System.out.print(dp[N][K]);
    }
}
