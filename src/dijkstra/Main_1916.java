package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Bus {
        int node, cost;

        public Bus(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int N, M;
    static int start, destination;
    static int[] dp;
    static boolean[] isVisited;
    static List<Bus>[] buses;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); //도시의 개수
        M = Integer.parseInt(br.readLine()); //버스의 개수

        dp = new int[N + 1];
        isVisited = new boolean[N + 1];
        buses = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            buses[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            buses[a].add(new Bus(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        dijkstra(start, destination);

        System.out.println(dp[destination]);
    }

    private static void dijkstra(int start, int destination) {
        PriorityQueue<Bus> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        Arrays.fill(dp, 1000000000);
        pq.offer(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus currentBus = pq.poll();

            if (currentBus.node == destination) break;

            if (isVisited[currentBus.node]) continue;
            isVisited[currentBus.node] = true;

            for (Bus nextBus : buses[currentBus.node]) {
                if (dp[nextBus.node] > currentBus.cost + nextBus.cost) {
                    dp[nextBus.node] = currentBus.cost + nextBus.cost;

                    pq.offer(new Bus(nextBus.node, dp[nextBus.node]));
                }
            }
        }
    }
}
