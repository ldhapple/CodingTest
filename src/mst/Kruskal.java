package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25

159

그래프가 모든 노드를 포함하면서도 사이클이 존재하지 않는 부분 그래프 (서로 연결은 되어 있으나 사이클은 X)
최소한의 비용으로 모두를 연결해야 한다.
 */
public class Kruskal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V, E, result; //정점, 간점
    static int[] parent;
    static Edge[] edges;

    static class Edge {
        public int v1;
        public int v2;
        public int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        makeSet();

        edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, cost);
        }

        //크루스칼 알고리즘
        /*
        간선 정렬
        집합 배열 처리
         */

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);
        makeSet();

        int cnt = 0; //V-1개 만들면 됨. (사이클이 없도록)

        for (Edge edge : edges) {
            if (union(edge.v1, edge.v2)) {
                result += edge.cost;
                cnt++;
            }

            if (cnt == V - 1) break;
        }

        System.out.println(result);
    }

    static void makeSet() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == py) return false;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }

        return true;
    }
}
