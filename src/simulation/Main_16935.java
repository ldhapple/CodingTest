package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main_16935 { //배열 돌리기 3
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, R;
    static int[][] arr;
    static int[] rotateArr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        rotateArr = new int[R];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            rotateArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            int rotateNum = rotateArr[i];

            switch (rotateNum) {
                case 1:
                    rotate1();
                    break;

                case 2:
                    rotate2();
                    break;

                case 3:
                    rotate3();
                    break;

                case 4:
                    rotate4();
                    break;

                case 5:
                    rotate5();
                    break;

                case 6:
                    rotate6();
                    break;
            }
        }

        for (int[] ary : arr) {
            for (int val : ary) {
                sb.append(val + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void rotate1() {
        int[][] tempArr = new int[N][M];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tempArr[y][x] = arr[N - 1 - y][x];
            }
        }

        arr = tempArr;
    }

    private static void rotate2() {
        int[][] tempArr = new int[N][M];

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                tempArr[y][x] = arr[y][M - 1 - x];
            }
        }

        arr = tempArr;
    }

    private static void rotate3() {
        int[][] tempArr = new int[M][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tempArr[x][N - 1 - y] = arr[y][x];
            }
        }

        int temp = N;
        N = M;
        M = temp;

        arr = tempArr;
    }

    private static void rotate4() {
        int[][] tempArr = new int[M][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tempArr[M - 1 - x][y] = arr[y][x];
            }
        }

        int temp = N;
        N = M;
        M = temp;

        arr = tempArr;
    }

    private static void rotate5() {
        int[][] tempArr = new int[N][M];

        int[] dy = {0, N/2, 0, -(N/2)}; //오 -> 아 -> 왼 -> 위
        int[] dx = {M/2, 0, -(M/2), 0};

        int idx = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (y < N/2 && x < M/2) {
                    idx = 0;
                }

                if (y >= N/2 && x < M/2) {
                    idx = 3;
                }

                if (y >= N/2 && x >= M/2) {
                    idx = 2;
                }

                if (y < N/2 && x >= M/2) {
                    idx = 1;
                }

                int ny = y + dy[idx];
                int nx = x + dx[idx];

                tempArr[ny][nx] = arr[y][x];
            }
        }

        arr = tempArr;
    }

    private static void rotate6() {
        int[][] tempArr = new int[N][M];

        int[] dy = {0, N/2, 0, -(N/2)}; //오 -> 아 -> 왼 -> 위
        int[] dx = {M/2, 0, -(M/2), 0};

        int idx = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (y < N/2 && x < M/2) {
                    idx = 1;
                }

                if (y < N/2 && x >= M/2) {
                    idx = 2;
                }

                if (y >= N/2 && x >= M/2) {
                    idx = 3;
                }

                if (y >= N/2 && x < M/2) {
                    idx = 0;
                }


                int ny = y + dy[idx];
                int nx = x + dx[idx];

                tempArr[ny][nx] = arr[y][x];
            }
        }

        arr = tempArr;
    }
}
