package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16398_Kruskal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] parent;
    static List<Flow> flows = new ArrayList<>();
    static long answer = 0;

    static class Flow {
        public int node1;
        public int node2;
        public int cost;

        public Flow(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    st.nextToken();
                } else {
                    flows.add(new Flow(i, j, Integer.parseInt(st.nextToken())));
                }
            }
        }

        makeSet();

        Collections.sort(flows, (a, b) -> a.cost - b.cost);

        int cnt = 0;
        for (Flow flow : flows) {
            if (union(flow.node1, flow.node2)) {
                answer += flow.cost;
                cnt++;
            }

            if (cnt == N - 1) break;
        }

        if (N == 1) answer = 0;

        System.out.println(answer);
    }

    public static void makeSet() {
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    public static int findSet(int x) {
        if (parent[x] == x) return x;

        return parent[x] = findSet(parent[x]);
    }
    public static boolean union(int x, int y) {
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
