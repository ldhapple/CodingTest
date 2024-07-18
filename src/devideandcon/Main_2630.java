package devideandcon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int blueCnt = 0;
    static int whiteCnt = 0;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void search(int nowY, int nowX, int size) {
        if (isAllSameColor(nowY, nowX, size)) {
            int color = map[nowY][nowX];

            if (color == 1) blueCnt++;
            else whiteCnt++;
        } else {
            int half = size / 2;

            search(nowY, nowX, half);
            search(nowY, nowX + half, half);
            search(nowY + half, nowX, half);
            search(nowY + half, nowX + half, half);
        }
    }

    private static boolean isAllSameColor(int nowY, int nowX, int size) {
        if (size == 1) return true;

        int color = map[nowY][nowX];

        for (int y = nowY; y < nowY + size; y++) {
            for (int x = nowX; x < nowX + size; x++) {
                if (map[y][x] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
