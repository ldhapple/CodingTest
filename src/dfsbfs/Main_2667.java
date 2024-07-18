package dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Integer> answer = new ArrayList<>();

    public static class Point {
        public int y;
        public int x;
        public int cnt;

        public Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int cnt = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) {
                    cnt++;
                    int count = 0;
                    queue.add(new Point(y, x, 1));
                    map[y][x] = 0;

                    while (!queue.isEmpty()) {
                        Point now = queue.poll();
                        count++;

                        for (int d = 0; d < 4; d++) {
                            int ny = now.y + dy[d];
                            int nx = now.x + dx[d];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                            if (map[ny][nx] == 0) continue;

                            queue.add(new Point(ny, nx, now.cnt + 1));
                            map[ny][nx] = 0;
                        }
                    }

                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(cnt);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
