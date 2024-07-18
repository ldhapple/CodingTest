package devideandcon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < N; x++) {
                arr[y][x] = str.charAt(x) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);
    }

    public static void quadTree(int y, int x, int size) {
        if (isAllSameColor(y, x, size)) {
            sb.append(arr[y][x]);
        } else {
            int half = size / 2;

            sb.append("(");
            quadTree(y, x, half);
            quadTree(y, x + half, half);
            quadTree(y + half, x, half);
            quadTree(y + half, x + half, half);
            sb.append(")");
        }
    }

    private static boolean isAllSameColor(int y, int x, int size) {
        if (size == 1) {
            return true;
        }

        int color = arr[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
