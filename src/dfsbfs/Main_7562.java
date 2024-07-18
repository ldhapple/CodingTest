package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static class Point {
        public int y;
        public int x;
        public int turn;

        public Point(int y, int x, int turn) {
            this.y = y;
            this.x = x;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int size = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(startY, startX, 0));

            boolean[][] isVisited = new boolean[size][size];
            isVisited[startY][startX] = true;

            int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};
            int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (now.y == endY && now.x == endX) {
                    System.out.println(now.turn);
                    break;
                }

                for (int d = 0; d < 8; d++) {
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= size || nx >= size) continue;
                    if (isVisited[ny][nx]) continue;

                    queue.add(new Point(ny, nx, now.turn + 1));
                    isVisited[ny][nx] = true;
                }
            }
        }
    }
}
