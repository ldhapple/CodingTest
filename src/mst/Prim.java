package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
크루스칼은 간선을 정렬하는 비용이 들어 간선이 많아지면 안될 수 있다.

시작점을 pq에 넣고 시작한다.
pq에 담긴 정점 중 가장 비용이 적은 정점을 꺼낸다.
그 정점에서 갈 수 있는 새로운 정점을 pq에 넣는다.
반복해서 비용이 가장 적은 정점이 V개 선택되면 된다.
 */
public class Prim {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V;
    static long result;
    static int[][] matrix;
    static boolean[] isVisited;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.cost = b.cost);

    static class Vertex {
        int v, cost;

        public Vertex(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws Exception {
        V = Integer.parseInt(br.readLine());
        matrix = new int[V][V];
        isVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 2000000000;

        for (int i = 0; i < V; i++) {
            result = Math.min(result, prim(i));
        }

        System.out.println(result);
    }

    private static int prim(int start) {
        pq.offer(new Vertex(start, 0));
        int totalCnt = 0;
        int totalCost = 0;
        Arrays.fill(isVisited, false);

        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();

            if (isVisited[vertex.v]) continue;
            isVisited[vertex.v] = true;
            totalCost += vertex.cost;
            totalCnt++;

            if (totalCnt == V) break;

            for (int i = 0; i < V; i++) {
                if (matrix[vertex.v][i] == 0 || isVisited[i]) continue;
                pq.offer(new Vertex(i, matrix[vertex.v][i]));
            }
        }

        return totalCost;
    }
}
