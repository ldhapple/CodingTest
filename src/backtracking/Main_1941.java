package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//25명중 7명을 뽑고 그 7명이 모두 이어져있는지 bfs로 확인한다.
/*
   25명중 7명을 뽑는 것을 백트래킹
   그리고 그 7명에 대해 bfs를 진행한다.
*/

public class Main_1941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] arr = new char[5][5];
    static int answer = 0;
    static int[] selectedPoint = new int[7];
    static boolean[] isSelected = new boolean[25];

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        bt(0, 0, 0);
        System.out.println(answer);
    }

    static void bt(int idx, int depth, int sCnt) {
        if (depth == 7) {
            if (sCnt >= 4) {
                answer += bfs();
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            if (isSelected[i]) continue;

            selectedPoint[depth] = i;
            isSelected[i] = true;

            if (arr[i / 5][i % 5] == 'S') {
                bt(i + 1, depth + 1, sCnt + 1);
            } else {
                bt(i + 1, depth + 1, sCnt);
            }

            isSelected[i] = false;
        }
    }

    static int bfs() {
        boolean[][] isVisited = new boolean[5][5];
        int count = 1;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(selectedPoint[0] / 5, selectedPoint[0] % 5));
        isVisited[selectedPoint[0] / 5][selectedPoint[0] % 5] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = currentPoint.y + dy[d];
                int nx = currentPoint.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
                if (isVisited[ny][nx]) continue;
                if (!isSelected[(ny * 5) + nx]) continue;

                count++;
                queue.offer(new Point(ny, nx));
                isVisited[ny][nx] = true;
            }
        }

        if (count == 7) return 1;
        return 0;
    }
}
