package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

// 1차원 배열로 이진트리 표현
/*
                1
           2          3
         4    5     6    7
        8 9 10 11 12 13 14 15
 */

public class BinaryTreeSearch {
    static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        sb.setLength(0);

        dfs(1);
        System.out.println(sb);
    }

    static void bfs(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();

            sb.append(tree[curIdx]).append(" ");

            int lcIdx = curIdx * 2;
            int rcIdx = curIdx * 2 + 1;

            if (lcIdx < tree.length) queue.offer(lcIdx);
            if (rcIdx < tree.length) queue.offer(rcIdx);
        }
    }

    static void dfs(int idx) {
        sb.append(tree[idx] + " ");

        if (idx * 2 < tree.length) dfs(idx * 2);
        if (idx * 2 + 1 < tree.length) dfs(idx * 2 + 1);
    }
}
