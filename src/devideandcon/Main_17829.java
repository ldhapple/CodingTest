package devideandcon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;
    static int[][] temp;
    static int yIdx;
    static int xIdx;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        search(N);

        System.out.println(arr[0][0]);
    }

    private static void search(int size) {
        if (size == 1) return;

        yIdx = 0;
        xIdx = 0;

        for (int y = 0; y < size; y += 2) {
            for (int x = 0; x < size; x += 2) {
                findNum(y, x);
                xIdx++;
            }
            yIdx++;
            xIdx = 0;
        }

        search(size / 2);
    }

    private static void findNum(int nowY, int nowX) {
        List<Integer> list = new ArrayList<>();

        for (int y = nowY; y < nowY + 2; y++) {
            for (int x = nowX; x < nowX + 2; x++) {
                list.add(arr[y][x]);
            }
        }

        Collections.sort(list);
        arr[yIdx][xIdx] = list.get(2);
    }
}
