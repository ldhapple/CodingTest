package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Bus>[] buses;
    static int startNode, destinationNode;

    static int[] dp;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static List<Integer>[] visitedCity = new List[N + 1];

    public static class Bus {
        public int destination;
        public int cost;

        public Bus(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); //지역 수
        M = Integer.parseInt(br.readLine()); //버스 수

        buses = new ArrayList[N + 1];
        visitedCity = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            buses[i] = new ArrayList<>();
            visitedCity[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            buses[nodeA].add(new Bus(nodeB, cost));
        }

        st = new StringTokenizer(br.readLine());

        startNode = Integer.parseInt(st.nextToken());
        destinationNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode, destinationNode);

        System.out.println(dp[destinationNode]);
        System.out.println(visitedCity[destinationNode].size());
        for (int val : visitedCity[destinationNode]) {
            System.out.print(val + " ");
        }
    }

    private static void dijkstra(int startNode, int destinationNode) {
        dp = new int[N + 1];
        Arrays.fill(dp, INF);
        dp[startNode] = 0;

        isVisited = new boolean[N + 1];

        PriorityQueue<Bus> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Bus(startNode, 0));
        visitedCity[startNode].add(startNode);

        while (!pq.isEmpty()) {
            Bus currentBus = pq.poll();

            if (currentBus.destination == destinationNode) break;

            if (isVisited[currentBus.destination]) continue;
            isVisited[currentBus.destination] = true;

            for (Bus nextBus : buses[currentBus.destination]) {
                if (isVisited[nextBus.destination]) continue;

                if (dp[nextBus.destination] > currentBus.cost + nextBus.cost) {
                    dp[nextBus.destination] = currentBus.cost + nextBus.cost;
                    visitedCity[nextBus.destination].clear();

                    for (int j = 0; j < visitedCity[currentBus.destination].size(); j++) {
                        visitedCity[nextBus.destination].add(visitedCity[currentBus.destination].get(j));
                    }

                    visitedCity[nextBus.destination].add(nextBus.destination);
                    pq.offer(new Bus(nextBus.destination, dp[nextBus.destination]));
                }
            }
        }
    }
}
