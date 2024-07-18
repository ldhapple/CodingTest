package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] population;
    static List<Integer>[] graph;
    static boolean[] isSelectedOne;
    static List<Integer> strict1 = new ArrayList<>();
    static List<Integer> strict2 = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        graph = new List[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int b = Integer.parseInt(st.nextToken());

                graph[i].add(b);
            }
        }

        isSelectedOne = new boolean[N + 1];
        bt(1);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void bt(int depth) {
        if (depth == N + 1) {
            strict1.clear();
            strict2.clear();

            for (int i = 1; i < isSelectedOne.length; i++) {
                if (isSelectedOne[i]) strict1.add(i);
                else strict2.add(i);
            }

            if (strict1.isEmpty() || strict2.isEmpty()) return;

            if (!isConnected(strict1) || !isConnected(strict2)) {
                return;
            }

            int gu1 = 0;
            int gu2 = 0;

            for (int i = 1; i <= N; i++) {
                if (isSelectedOne[i]) gu1 += population[i];
                else gu2 += population[i];
            }

            min = Math.min(min, Math.abs(gu1 - gu2));

            return;
        }

        isSelectedOne[depth] = true;
        bt(depth + 1);

        isSelectedOne[depth] = false;
        bt(depth + 1);
    }


    static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(group.get(0));
        visited[group.get(0)] = true;

        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (group.contains(next) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    visitedCount++;
                }
            }
        }

        return visitedCount == group.size();
    }
}
