import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= 10; test++) {
            int T = Integer.parseInt(br.readLine());

            int[][] ladder = new int[100][100];

            int startY = 99;
            int startX = 0;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    ladder[i][j] = value;

                    if (value == 2) {
                        startX = j;
                    }
                }
            }

            Point start = new Point(startY, startX);

            int[] dx = {-1,1};

            while(true) {
                if (start.y == 0) break;

                boolean flag = false;
                for (int i = 0; i < 2; i++) {
                    int nx = start.x + dx[i];

                    if (nx < 0 || nx >= 100) continue;
                    if (ladder[start.y][nx] != 1) continue;
                    if (flag) continue;

                    start.setX(nx);
                    flag = true;

                    while(true) {
                        nx = start.x + dx[i];

                        if (nx < 0 || nx >= 100 || ladder[start.y][nx] != 1) break;

                        start.setX(nx);
                    }
                }
                start.setY(start.y - 1);
            }

            System.out.printf("#%d %d\n", test, start.x);
        }
    }
}
