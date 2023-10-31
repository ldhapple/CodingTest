import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    /**
     * 간선을 제거하면 무조건 그래프가 2개 이상으로 나뉜다.
     * 단절선을 물어보는 경우는 무조건 YES를 출력한다.
     * 단절점을 뜻하는 노드를 제거하는 경우는
     * 해당 노드와 연결된 노드가 2개 이상이라면
     * 그 노드를 지우면 트리가 2개로 나뉘어진다.
     */
    static class Node {
        List<Node> leaf = new ArrayList<>();

        public void connect(Node o) {
            o.leaf.add(this);
            this.leaf.add(o);
        }

        public int leafSize() {
            return this.leaf.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            nodes[n1].connect(nodes[n2]);
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int nodeNum = Integer.parseInt(st.nextToken());

            Node node = nodes[nodeNum];
            if (q == 2) {
                System.out.println("yes"); //단절선은 모든 경우가 단절선이다.
            } else {
                if (node.leafSize() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
