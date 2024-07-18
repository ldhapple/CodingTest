package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M, N, H;
    static int[][][] tomato;

    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static class Point {
        public int y;
        public int x;
        public int h;
        public int day;

        public Point(int y, int x, int h, int day) {
            this.y = y;
            this.x = x;
            this.h = h;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // x
        N = Integer.parseInt(st.nextToken()); // y
        H = Integer.parseInt(st.nextToken()); // h

        tomato = new int[N][M][H];

        Queue<Point> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[N][M][H];

        int tomatoCnt = 0;
        int emptyCnt = 0;

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    int num = Integer.parseInt(st.nextToken());
                    tomato[y][x][h] = num;

                    if (num == 1) {
                        queue.add(new Point(y, x, h, 0));
                        isVisited[y][x][h] = true;
                        tomatoCnt++;
                    }
                    if (num == -1) {
                        emptyCnt++;
                    }
                }
            }

            Collection<Integer> collection = List.of(1,2,3,4);
        }

        int result = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Point nowTomato = queue.poll();
            result = Math.max(result, nowTomato.day);

            for (int d = 0; d < 6; d++) {
                int ny = nowTomato.y + dy[d];
                int nx = nowTomato.x + dx[d];
                int nh = nowTomato.h + dh[d];

                if (ny < 0 || nx < 0 || nh < 0 || ny >= N || nx >= M || nh >= H) continue;
                if (isVisited[ny][nx][nh]) continue;
                if (tomato[ny][nx][nh] == -1 || tomato[ny][nx][nh] == 1) continue;

                queue.add(new Point(ny, nx, nh, nowTomato.day + 1));
                isVisited[ny][nx][nh] = true;
                tomato[ny][nx][nh] = 1;
                tomatoCnt++;
            }
        }

        if (tomatoCnt + emptyCnt != N * M * H) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
