import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Node{
        private Node parent = null;

        public Node root(){
            if(parent == null) return this;
            return parent = parent.root();
        }

        public boolean isConnected(Node o){
            return root() == o.root();
        }

        public void merge(Node o){
            if(isConnected(o)) return;
            o.root().parent = this;
        }
    }

    public static class Connect{
        public int city1;
        public int city2;

        public int cost;

        public Connect(int i, int j, int cost){
            this.city1 = i;
            this.city2 = j;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];

        for(int i = 0; i < N+1; i++){
            nodes[i] = new Node();
        }

        PriorityQueue<Connect> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        int total = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());

            int cost = Integer.parseInt(st.nextToken());
            total += cost;

            pq.add(new Connect(city1, city2, cost));
        }

        long total_cost = 0;

        while(!pq.isEmpty()){
            Connect c = pq.poll();

            int city1 = c.city1;
            int city2 = c.city2;
            int cost = c.cost;

            if(nodes[city1].isConnected(nodes[city2])) continue;

            nodes[city1].merge(nodes[city2]);
            total_cost += cost;
        }

        boolean connect_check = true;

        for(int i = 1; i < nodes.length - 1; i++){
            if(nodes[i].isConnected(nodes[i+1])) continue;
            connect_check = false;
        }

        if(connect_check){
            System.out.print(total - total_cost);
        }else{
            System.out.print(-1);
        }
    }
}
