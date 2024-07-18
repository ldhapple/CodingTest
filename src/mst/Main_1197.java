package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int a;
        public int b;
        public int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static int[] parent;
    static int V, E;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        edges = new Edge[E];

        setParent();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        int connectCnt = 0;
        int totalCost = 0;

        for (Edge edge : edges) {
            if (merge(edge.a, edge.b)) {
                totalCost += edge.cost;
                connectCnt++;
            }

            if (connectCnt == V - 1) break;
        }

        System.out.println(totalCost);
    }

    public static void setParent() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    public static int findParent(int x) {
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
