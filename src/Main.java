import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int result;
    static boolean[] isVisited;
    static int N;
    static int M;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 각각 1명씩만 친구가 있으면 됨.
         * 단, 모두가 연결되어 있어야 함.
         */

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //사람의 수
        M = Integer.parseInt(st.nextToken()); //친구 관계의 수

        list = new ArrayList[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            list[p1].add(p2);
            list[p2].add(p1);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int index, int depth) {
        if (depth >= 4) {
            result = 1;
            return;
        }

        for (int i : list[index]) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
