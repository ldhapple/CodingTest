package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K, W, H;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[] horseDy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseDx = {1, 2, 2, 1, -1, -2, -2, -1};

    static int answer = -1;
    static class Point {
        int y, x, horseCnt, totalCnt;

        public Point(int y, int x, int horseCnt, int totalCnt) {
            this.y = y;
            this.x = x;
            this.horseCnt = horseCnt;
            this.totalCnt = totalCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][][] isVisited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, 0));
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            if (currentPoint.y == H-1 && currentPoint.x == W-1) {
                answer = currentPoint.totalCnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ny = currentPoint.y + dy[d];
                int nx = currentPoint.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                if (map[ny][nx] == 1) continue;
                if (isVisited[ny][nx][currentPoint.horseCnt]) continue;

                queue.offer(new Point(ny, nx, currentPoint.horseCnt, currentPoint.totalCnt + 1));
                isVisited[ny][nx][currentPoint.horseCnt] = true;
            }

            if (currentPoint.horseCnt >= K) continue;

            for (int d = 0; d < 8; d++) {
                int ny = currentPoint.y + horseDy[d];
                int nx = currentPoint.x + horseDx[d];

                if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                if (map[ny][nx] == 1) continue;
                if (isVisited[ny][nx][currentPoint.horseCnt + 1]) continue;

                queue.offer(new Point(ny, nx, currentPoint.horseCnt + 1, currentPoint.totalCnt + 1));
                isVisited[ny][nx][currentPoint.horseCnt + 1] = true;
            }
        }

        System.out.println(answer);
    }
}
