package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static boolean[] isVisited;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            arr = new int[N];
            isVisited = new boolean[N];
            answer = new int[6];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            bt(0, 0);
            System.out.println();
        }
    }

    static void bt(int idx, int depth) {
        if (depth == 6) {
            for (int val : answer) {
                System.out.print(val + " ");
            }

            System.out.println();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (isVisited[i]) continue;

            isVisited[i] = true;
            answer[depth] = arr[i];
            bt(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }
}
