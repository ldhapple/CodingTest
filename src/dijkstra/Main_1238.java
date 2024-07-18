package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, X;

    static int[][] dp;
    static boolean[] isVisited;
    static ArrayList<Node>[] roads;
    static final int INF = 999999;

    public static class Node {
        public int dest;
        public int time;

        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //학생 수
        M = Integer.parseInt(st.nextToken()); //도로의 수
        X = Integer.parseInt(st.nextToken()); //파티 마을

        dp = new int[N + 1][N + 1];
        roads = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            roads[i] = new ArrayList<>();
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            roads[nodeA].add(new Node(nodeB, time));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i][X] + dp[X][i]);
        }

        System.out.println(answer);
    }

    private static void dijkstra(int startNode) {
        isVisited = new boolean[N + 1];
        dp[startNode][startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (isVisited[curNode.dest]) continue;
            isVisited[curNode.dest] = true;

            for (Node next : roads[curNode.dest]) {
                if (dp[startNode][next.dest] > curNode.time + next.time) {
                    dp[startNode][next.dest] = curNode.time + next.time;

                    pq.offer(new Node(next.dest, dp[startNode][next.dest]));
                }
            }
        }
    }
}
