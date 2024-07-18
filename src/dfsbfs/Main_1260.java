package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;

    static List<Integer>[] lists;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        lists = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(lists[i]);
        }

        isVisited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        bfs();

        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        isVisited = new boolean[N + 1];

        queue.add(V);
        isVisited[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");

            for (int i = 0; i < lists[now].size(); i++) {
                int next = lists[now].get(i);

                if (isVisited[next]) continue;

                isVisited[next] = true;
                queue.add(next);
            }
        }
    }

    private static void dfs(int now) {
        //stack 쓰려 했는데 작은 크기의 정점부터 방문하는 조건때문에 재귀로 수정.

        isVisited[now] = true;
        sb.append(now + " ");

        for (int i = 0; i < lists[now].size(); i++) {
            int next = lists[now].get(i);

            if (isVisited[next]) continue;

            dfs(next);
        }
    }
}
