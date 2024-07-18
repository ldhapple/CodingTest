package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 { //감시

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> cctv = new ArrayList<>();

    public static class Point {
        public int y;
        public int x;

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
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num != 6 && num != 0) {
                    cctv.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int cctvIdx, int depth) {
        if (depth == cctv.size()) {
            int noSize = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] == 0) {
                        noSize++;
                    }
                }
            }

            answer = Math.min(answer, noSize);
            return;
        }

        Point cctvPoint = cctv.get(cctvIdx);
        int cctvNum = map[cctvPoint.y][cctvPoint.x];

        switch (cctvNum) {
            case 1:
                cctv1(cctvPoint, cctvIdx, depth);
                break;
            case 2:
                cctv2(cctvPoint, cctvIdx, depth);
                break;
            case 3:
                cctv3(cctvPoint, cctvIdx, depth);
                break;
            case 4:
                cctv4(cctvPoint, cctvIdx, depth);
                break;
            case 5:
                cctv5(cctvPoint, cctvIdx, depth);
                break;
        }

    }

    public static int[][] copyBeforeMap(int[][] map) {
        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        return tempMap;
    }

    public static void cctv1(Point cctvPoint, int cctvIdx, int depth) {
        int[][] tempMap = copyBeforeMap(map);
        up(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);;

        right(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);;

        left(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);;
    }

    public static void cctv2(Point cctvPoint, int cctvIdx, int depth) {
        int[][] tempMap = copyBeforeMap(map);
        left(cctvPoint);
        right(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        up(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);
    }

    public static void cctv3(Point cctvPoint, int cctvIdx, int depth) {
        int[][] tempMap = copyBeforeMap(map);
        up(cctvPoint);
        right(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        right(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        left(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        left(cctvPoint);
        up(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);
    }

    public static void cctv4(Point cctvPoint, int cctvIdx, int depth) {
        int[][] tempMap = copyBeforeMap(map);
        up(cctvPoint);
        left(cctvPoint);
        right(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        up(cctvPoint);
        right(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        right(cctvPoint);
        left(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);

        down(cctvPoint);
        left(cctvPoint);
        up(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);
    }

    public static void cctv5(Point cctvPoint, int cctvIdx, int depth) {
        int[][] tempMap = copyBeforeMap(map);
        up(cctvPoint);
        left(cctvPoint);
        right(cctvPoint);
        down(cctvPoint);
        dfs(cctvIdx + 1, depth + 1);
        map = copyBeforeMap(tempMap);
    }

    public static void up(Point p) {
        for (int y = p.y - 1; y >= 0; y--) {
            if (map[y][p.x] == 6) {
                return;
            }
            if (map[y][p.x] != 0) {
                continue;
            }

            map[y][p.x] = -1;
        }
    }

    public static void down(Point p) {
        for (int y = p.y + 1; y < N; y++) {
            if (map[y][p.x] == 6) {
                return;
            }
            if (map[y][p.x] != 0) {
                continue;
            }

            map[y][p.x] = -1;
        }
    }

    public static void right(Point p) {
        for (int x = p.x + 1; x < M; x++) {
            if (map[p.y][x] == 6) {
                return;
            }
            if (map[p.y][x] != 0) {
                continue;
            }

            map[p.y][x] = -1;
        }
    }

    public static void left(Point p) {
        for (int x = p.x - 1; x >= 0; x--) {
            if (map[p.y][x] == 6) {
                return;
            }
            if (map[p.y][x] != 0) {
                continue;
            }

            map[p.y][x] = -1;
        }
    }
}
