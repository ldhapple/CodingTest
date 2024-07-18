package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int dp[];
    static boolean[] isVisited;

    static class Node{
        int nodeNum;
        int weight;

        public Node(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드개수
        int E = Integer.parseInt(st.nextToken()); //간선개수
        int K = Integer.parseInt(br.readLine()); //시작정점

        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++)
        {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dp = new int[N+1];
        Arrays.fill(dp, INF);

        isVisited = new boolean[N+1];

        dijkstra(K);

        for(int i = 1; i <= N; i++)
        {
            if(dp[i] == INF){
                sb.append("INF\n");
                continue;
            }

            sb.append(dp[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dp[start] = 0; //시작점과의 거리 = 0
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty())
        {
            Node now = queue.poll();
            int curNode = now.nodeNum;

            if (isVisited[curNode]) continue;

            isVisited[curNode] = true;

            for (Node nextNode : graph[curNode]) {
                if (dp[nextNode.nodeNum] > dp[curNode] + nextNode.weight) {
                    dp[nextNode.nodeNum] = dp[curNode] + nextNode.weight;
                    queue.offer(new Node(nextNode.nodeNum, dp[nextNode.nodeNum]));
                }
            }
        }
    }
}
