package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static int N;
    static int[][] graph;
    static Point baby;
    static int babySize = 2;
    static int totalTime = 0;
    static int eatFishCnt = 0;

    static class Point implements Comparable<Point> {
        int y, x, dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point other) {
            if (this.dist == other.dist) {
                if (this.y == other.y) {
                    return this.x - other.x;
                }
                return this.y - other.y;
            }
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 9) {
                    baby = new Point(i, j, 0);
                    graph[i][j] = 0;
                }
            }
        }

        while (true) {
            boolean foundFish = bfs();
            if (!foundFish) {
                break;
            }
        }

        System.out.println(totalTime);
    }

    static boolean bfs() {
        boolean[][] isVisited = new boolean[N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(baby);
        isVisited[baby.y][baby.x] = true;

        Point targetFish = null;

        while (!pq.isEmpty()) {
            Point current = pq.poll();

            if (graph[current.y][current.x] > 0 && graph[current.y][current.x] < babySize) {
                targetFish = current;
            }

            if (targetFish != null) {
                baby = new Point(targetFish.y, targetFish.x, 0);
                eatFishCnt++;
                graph[targetFish.y][targetFish.x] = 0;
                totalTime += targetFish.dist;

                if (eatFishCnt == babySize) {
                    babySize++;
                    eatFishCnt = 0;
                }
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int ny = current.y + dy[d];
                int nx = current.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                if (isVisited[ny][nx]) {
                    continue;
                }
                if (graph[ny][nx] > babySize) {
                    continue;
                }

                isVisited[ny][nx] = true;
                pq.offer(new Point(ny, nx, current.dist + 1));
            }
        }

        return false;
    }
}
