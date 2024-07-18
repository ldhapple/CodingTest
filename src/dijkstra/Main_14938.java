package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static class Node {
        public int nodeNum;
        public int distance;

        public Node(int nodeNum, int distance) {
            this.nodeNum = nodeNum;
            this.distance = distance;
        }
    }

    static int N, M, R;
    static int[] items;
    static ArrayList<Node>[] routes;
    static int answer = Integer.MIN_VALUE;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //지역 개수
        M = Integer.parseInt(st.nextToken()); //최대 수색 범위
        R = Integer.parseInt(st.nextToken()); //길의 개수

        items = new int[N + 1];
        routes = new ArrayList[N + 1];
        routes[0] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            routes[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            routes[nodeA].add(new Node(nodeB, dist));
            routes[nodeB].add(new Node(nodeA, dist));
        }

        for (int startNode = 1; startNode <= N; startNode++) {
            dijkstra(startNode);
        }

        System.out.println(answer);
    }


    /*
    PriorityQueue를 사용하기 때문에 isVisited를 평소 bfs하듯 next를 queue에 넣을 때 true 처리해버리면
    더 짧은 거리임에도 방문을 못하는 경우가 생김
    긴 경로 그대로를 방문처리 해버림.
    따라서 PriorityQueue에서 뽑아쓸때 방문처리 해줘야 함.
     */

    private static void dijkstra(int startNode) {
        int getItemCnt = 0;
        isVisited = new boolean[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (isVisited[currentNode.nodeNum]) continue;

            getItemCnt += items[currentNode.nodeNum];
            isVisited[currentNode.nodeNum] = true;

            for (Node nextNode : routes[currentNode.nodeNum]) {
                int totalDist = nextNode.distance + currentNode.distance;

                if (totalDist > M) continue;
                if (isVisited[nextNode.nodeNum]) continue;

                pq.offer(new Node(nextNode.nodeNum, totalDist));
            }
        }

        answer = Math.max(answer, getItemCnt);
    }
}
