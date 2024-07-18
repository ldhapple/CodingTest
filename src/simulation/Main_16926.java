package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_16926 { //배열 돌리기 1
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] arr;
    static int N;
    static int M;
    static int R;

    static int[] dy = {1, 0, -1, 0}; //아래 -> 오른쪽 -> 위 -> 왼쪽
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        for(int[] ary : arr){
            for(int num : ary){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void rotate() {
        int beltCnt = Math.min(N, M) / 2;
        int[][] tempArr = new int[N][M];

        for (int beltIdx = 0; beltIdx < beltCnt; beltIdx++) {
            int y = beltIdx;
            int x = beltIdx;

            int direction = 0;

            while (direction < 4) {
                int ny = y + dy[direction];
                int nx = x + dx[direction];

                if (ny >= 0 + beltIdx && nx >= 0 + beltIdx && ny < N - beltIdx && nx < M - beltIdx) {
                    tempArr[ny][nx] = arr[y][x];
                    y = ny;
                    x = nx;
                } else {
                    direction++;
                }
            }
        }
        arr = tempArr;
    }
}

