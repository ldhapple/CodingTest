package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//외판원 순회는 사이클이 있는 그래프이기 때문에 방문할 곳이 정해지면 어느 정점에서 방문을 시작해도 비용이 같다.
//dp[i][j] = 현재 i번 도시에 있고, 거쳐온 도시들이 j로 표시된다. j를 보면 남은 도시가 있을 것. 남은 도시들을 방문하는데 필요한 최소 비용을 갱신한다.
//dp[3][1100101] = 1,3,6,7번 도시를 방문 후 3번 도시 상태일 때 남은 도시 2,4,5를 방문하는데 드는 최소 비용
//dp[3][1100101]의 최소 비용은 남은 2,4,5를 각각 방문하는 과정에서 최소 비용으로 갱신된다.
//dp[3][1100101]은 dp[2][1100111], dp[4][1101101], dp[5][1110101] 각각의 최소 비용을 재귀호출로 계산
//각각의 최소비용 + 3 -> (2|4|5) 각각으로 가는 비용을 더한 값 중 최소 비용으로 결정된다.
public class Main_2098 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int allVisited;
    static int[][] graph;
    static int[][] dp;
    static final int INF = 11000000;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        allVisited = (1 << N) - 1;
        graph = new int[N][N];
        dp = new int[N][allVisited]; // 1 << 5 = 100000 = 32

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1)); //0번 도시부터 출발, bitmask = 1
    }

    //이진수를 이용해 1이면 방문, 0이면 미방문 표시
    //1101 이면 0을 방문하기 전 최소치를 가지는 나머지를 방문한 경로가 dp에 저장되어 있다.
    //0010 이면 1번 도시를 방문한 것. (0010 = 2)
    static int dfs(int cityIdx, int visitBitmask) {
        if (visitBitmask == allVisited) { //모든 도시를 방문한 경우 1111 (1 << 4 => 10000)
            if (graph[cityIdx][0] == 0) { //시작점으로 되돌아 갈 수 있는 방법이 없다. = 사이클이 안만들어진다.
                return INF;
            }

            return graph[cityIdx][0]; //되돌아 가는 비용을 찾는 것. (다 방문했고, 이제 되돌아 가는 비용을 찾는다. = 현 시점에서 시작점으로 돌아가는 비용)
        }

        //이미 최소 비용이 계산되어 있다. = 그냥 그 값 써라.
        //1-3-6 순서나 6-3-1순서나 최소비용은 같기 때문에 여기서 dp를 활용해 효율 up
        if (dp[cityIdx][visitBitmask] != INF) {
            return dp[cityIdx][visitBitmask];
        }

        //현재 도시에서 각 도시로 이동한 경우
        for (int next = 0; next < N; next++) {
            //현재 도시에서 next로 갈 수 없거나, next도시를 cityIdx 도착 전 이미 방문했다면 스킵
            if (graph[cityIdx][next] == 0 || (visitBitmask & (1 << next)) != 0) continue;
            //visitBitmask & (1 << next) => 대응되는 비트가 둘 다 1이어야 1을 반환한다.
            //즉 0이 아닌 경우 next를 이미 방문했다는 뜻. 따라서 스킵. 둘 다 1을 반환하려면 visitBitmask에서 이미 1 << next에 해당하는 1이 1로 체크되어 있다는 뜻.

            dp[cityIdx][visitBitmask] = Math.min(dp[cityIdx][visitBitmask], graph[cityIdx][next] + dfs(next, visitBitmask | (1 << next)));
            //visitBitmask | (1 << next) => 대응되는 비트 중 하나라도 1이면 1을 반환한다. (방문체크) 1010 | 10000 = 11010
        }

        return dp[cityIdx][visitBitmask];
    }
}
