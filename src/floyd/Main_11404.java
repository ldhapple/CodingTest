package floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = 999999999;
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); //도시의 개수
        M = Integer.parseInt(br.readLine()); //버스의 개수

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;

                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()); //출발지
            int v = Integer.parseInt(st.nextToken()); //도착지
            int c = Integer.parseInt(st.nextToken()); //필요 비용

            //버스가 있을 때 목적지가 같다면 비용이 싼 노선을 골라야 함.
            arr[u][v] = Math.min(arr[u][v], c);
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 갈 수 없는 곳은 0으로 초기화
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }

                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) { //경유지
            for (int i = 1; i <= N; i++) { //출발지
                if (i == k) continue;

                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]); //기존 비용이, 경유지를 거치는 것 보다 크다면 경유지를 거치는 것으로 변경
                }
            }
        }
    }
}
