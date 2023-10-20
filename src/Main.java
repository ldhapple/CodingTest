import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R;
    static int C;
    static int N;
    static char[][] table;
    static int[][] isBoom;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); //N초가 지난 후의 격자판 상태

        table = new char[R][C];
        isBoom = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                table[i][j] = str.charAt(j);
                if (str.charAt(j) == 'O') {
                    isBoom[i][j] = 3;
                }
            }
        }

        int sec = 0;
        while(sec++ < N) {
            if (sec == 1) continue;

            if (sec % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (table[i][j] == '.') {
                            isBoom[i][j] = sec + 3;
                            table[i][j] = 'O';
                        }
                    }
                }
            }else if (sec % 2 != 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (isBoom[i][j] != sec) continue;
                        table[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;

                            table[ny][nx] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.out.println(table[i]);
        }
    }
}
