package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static class Point {
        public int h;
        public int y;
        public int x;
        public int sec;

        public Point(int h, int y, int x, int sec) {
            this.h = h;
            this.y = y;
            this.x = x;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws Exception {

        while (true) {
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (H == 0 && N == 0 && M == 0) break;

            char[][][] map = new char[H][N][M];

            Queue<Point> queue = new LinkedList<>();
            boolean[][][] isVisited = new boolean[H][N][M];

            for (int h = 0; h < H; h++) {
                for (int y = 0; y < N; y++) {
                    String str = br.readLine();
                    for (int x = 0; x < M; x++) {
                        char c = str.charAt(x);

                        map[h][y][x] = c;

                        if (c == 'S') {
                            queue.offer(new Point(h, y, x, 0));
                            isVisited[h][y][x] = true;
                        }
                    }
                }
                br.readLine();
            }

            int[] dh = {1, -1, 0, 0, 0, 0};
            int[] dy = {0, 0, 1, -1, 0, 0};
            int[] dx = {0, 0, 0, 0, 1, -1};

            int answer = -1;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (map[now.h][now.y][now.x] == 'E') {
                    answer = now.sec;
                    break;
                }

                for (int d = 0; d < 6; d++) {
                    int nh = now.h + dh[d];
                    int ny = now.y + dy[d];
                    int nx = now.x + dx[d];

                    if (nh < 0 || ny < 0 || nx < 0 || nh >= H || ny >= N || nx >= M) continue;
                    if (isVisited[nh][ny][nx]) continue;
                    if (map[nh][ny][nx] == '#') continue;

                    queue.offer(new Point(nh, ny, nx, now.sec + 1));
                    isVisited[nh][ny][nx] = true;
                }
            }

            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", answer);
            }
        }
    }
}
