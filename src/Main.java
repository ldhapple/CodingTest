import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    private static class Node{
        private Node parent = null;

        public boolean isConnected(Node o){
            return root() == o.root();
        }

        public void merge(Node o){
            if(isConnected(o)) return;
            o.root().parent = this;
        }

        private Node root(){
            if(parent == null) return this; // 루트노드 전용
            return parent = parent.root();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < N-2; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            Node node1 = nodes[num1];
            Node node2 = nodes[num2];


            if (node1.isConnected(node2)) continue;
            node1.merge(node2);
        }


        for (int i = 2; i <= N; i++) {
            if (!nodes[1].isConnected(nodes[i])) {
                System.out.print(1 + " " + i);
                break;
            }
        }
    }
}
