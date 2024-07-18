package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static int[] parent;
    static Edge[] edges;
    static int N, M;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        int total = 0;
        int lastConnectCost = 0;

        for (int i = 0; i < edges.length; i++) {
            int houseA = edges[i].a;
            int houseB = edges[i].b;

            if (merge(houseA, houseB)) {
                lastConnectCost = edges[i].cost;
                //마지막에 연결된 간선이 가장 비용이 비싼 도로
                //따라서 그 간선을 해제하면 마을은 두 개로 나뉘고, 각각의 마을을 연결하는 도로의 비용은 최소가 됨.
                total += edges[i].cost;
            }
        }

        System.out.println(total - lastConnectCost);
    }

    static int findParent(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findParent(parent[x]);
    }

    public static boolean merge(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px == py) return false;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }

        return true;
    }
}
