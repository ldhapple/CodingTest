import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지역의 수
        int M = Integer.parseInt(st.nextToken()); // 수색범위
        int R = Integer.parseInt(st.nextToken()); // 길의 수

        st = new StringTokenizer(br.readLine());

        int[] items = new int[N];

        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] edges = new int[N][N];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int D = Integer.parseInt(st.nextToken());

            edges[A][B] = D;
            edges[B][A] = D;
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, maxItem(i, edges, items, M));
        }

        System.out.print(max);
    }

    public static int maxItem(int lendingPoint, int[][] edges, int[] items, int maxRange){
        boolean[] isVisited = new boolean[items.length];
        int item_sum = items[lendingPoint];



        PriorityQueue<int[]> q = new PriorityQueue<>();
        q.offer(new int[] {lendingPoint, 0});
        isVisited[lendingPoint] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < edges[point[0]].length; i++) {
                if (isVisited[i]) continue;
                if (edges[point[0]][i] != 0 && edges[point[0]][i] <= maxRange - point[1]) {
                    item_sum += items[i];
                    isVisited[i] = true;
                    q.offer(new int[] {i, point[1] + edges[point[0]][i]});
                }
            }
        }

        return item_sum;
    }
}
