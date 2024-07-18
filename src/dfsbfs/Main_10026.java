package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int notWeak = 0;
    static int weak = 0;

    static int N;
    static char[][] arr;
    static boolean[][] isVisited_weak;
    static boolean[][] isVisited_notWeak;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        isVisited_notWeak = new boolean[N][N];
        isVisited_weak = new boolean[N][N];

        Queue<Point> notWeakQueue = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (isVisited_notWeak[y][x]) continue;

                notWeakQueue.offer(new Point(y, x));
                isVisited_notWeak[y][x] = true;

                while (!notWeakQueue.isEmpty()) {
                    Point now = notWeakQueue.poll();

                    for (int i = 0; i < 4; i++) {
                        int ny = now.y + dy[i];
                        int nx = now.x + dx[i];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                        if (isVisited_notWeak[ny][nx]) continue;
                        if (arr[ny][nx] != arr[now.y][now.x]) continue;

                        notWeakQueue.offer(new Point(ny, nx));
                        isVisited_notWeak[ny][nx] = true;
                    }
                }

                notWeak++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }

        Queue<Point> weakQueue = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (isVisited_weak[y][x]) continue;

                weakQueue.offer(new Point(y, x));
                isVisited_weak[y][x] = true;

                while (!weakQueue.isEmpty()) {
                    Point now = weakQueue.poll();

                    for (int i = 0; i < 4; i++) {
                        int ny = now.y + dy[i];
                        int nx = now.x + dx[i];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                        if (isVisited_weak[ny][nx]) continue;
                        if (arr[ny][nx] != arr[now.y][now.x]) continue;

                        weakQueue.offer(new Point(ny, nx));
                        isVisited_weak[ny][nx] = true;
                    }
                }

                weak++;
            }
        }

        System.out.print(notWeak + " " + weak);
    }
}
