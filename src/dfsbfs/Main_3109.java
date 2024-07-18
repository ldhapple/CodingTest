package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static char[][] graph;
    static int answer = 0;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    static boolean[][] isVisited;
    static boolean isCheck;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            isCheck = false;
            isVisited[i][0] = true;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int y, int x) {
        if (x == C - 1) {
            answer++;
            isCheck = true;
            //한 점에서 출발한 dfs가 빵집까지 도달했을 경우 true로 바꾸어 줌.
            //한 점에서 출발한 경로가 빵집에 도달했다면 그 점에서 출발한 빵집에 도달하는 다른 경로들은 파이프가 겹치기 때문에 의미 없음
            //그래서 true로 바꾸어 그 점에서는 체크하지 않도록.
            //방향의 순서도 중요함 대각 위 -> 일자 -> 대각 아래
            //이 순서를 바꿀 경우 예제 1번을 예로 들면 길을 막아서(isVisited) 경로가 1가지 밖에 안나옴.
            return;
        }

        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (graph[ny][nx] == 'x') continue;
            if (isVisited[ny][nx]) continue;

            if (isCheck) break;

            isVisited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}
