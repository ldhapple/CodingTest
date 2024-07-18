package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer = Integer.MIN_VALUE;
    static int N, M;
    static int[][] map;
    static List<Point> isVirus = new ArrayList<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int wallSize = 3;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    isVirus.add(new Point(i, j));
                }

                if (map[i][j] == 1) {
                    wallSize++;
                }
            }
        }

        bt(0, 0);

        System.out.println(answer);
    }

    static void bt(int idx, int depth) {
        if (depth == 3) {
            int totalSafe = N * M - wallSize - bfs() ;

            answer = Math.max(answer, totalSafe);
            return;
        }

        for (int i = idx; i < N * M; i++) {
            int y = i / M;
            int x = i % M;

            if (map[y][x] == 0) {
                map[y][x] = 1;
                bt(i + 1, depth + 1);
                map[y][x] = 0;
            }
        }
    }

    static int bfs() {
        boolean[][] isVisited = new boolean[N][M];
        int cnt = 0;

        Queue<Point> queue = new LinkedList<>();

        for (Point v : isVirus) {
            queue.offer(v);
            isVisited[v.y][v.x] = true;
            cnt++;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = current.y + dy[d];
                int nx = current.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (isVisited[ny][nx]) continue;
                if (map[ny][nx] == 1 || map[ny][nx] == 2) continue;

                if (map[ny][nx] == 0) {
                    queue.offer(new Point(ny, nx));
                    isVisited[ny][nx] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
