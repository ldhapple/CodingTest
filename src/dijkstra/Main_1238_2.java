package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_2 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] straightRoad;
    static List<Node>[] reverseRoad;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.t - b.t);
    static boolean[] isVisited;
    static int[] straightTime;
    static int[] reverseTime;
    static int N, M, X, max;

    static class Node {
        public int v;
        public int t;

        public Node(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        straightRoad = new List[N + 1];
        reverseRoad = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            straightRoad[i] = new ArrayList<>();
            reverseRoad[i] = new ArrayList<>();
        }

        straightTime = new int[N + 1];
        reverseTime = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            straightRoad[a].add(new Node(b, t));
            reverseRoad[b].add(new Node(a, t));
        }

        max = Integer.MIN_VALUE;

        dijkstra(straightRoad, straightTime);
        dijkstra(reverseRoad, reverseTime);

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, straightTime[i] + reverseTime[i]);
        }

        System.out.println(max);
    }

    static void dijkstra(List<Node>[] roads, int[] time) {
        Arrays.fill(time, INF);
        Arrays.fill(isVisited, false);

        pq.offer(new Node(X, 0));
        time[X] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (isVisited[current.v]) continue;
            isVisited[current.v] = true;

            for (Node next : roads[current.v]) {
                if (isVisited[next.v]) continue;
                if (time[next.v] > current.t + next.t) {
                    time[next.v] = current.t + next.t;
                    pq.offer(new Node(next.v, time[next.v]));
                }
            }
        }
    }
}
