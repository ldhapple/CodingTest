import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<ArrayList<Integer>> table = new ArrayList<>();
        boolean[][] isVisited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            table.add(new ArrayList<>());
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                table.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int cnt = 0;
        int bingo_cnt = 0;
        for (int i = 0;  i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int check_num = Integer.parseInt(st.nextToken());
                cnt++;
                int y = 0;
                int x = 0;

                for (int k = 0; k < 5; k++) {
                    int check = table.get(k).indexOf(check_num);
                    if (check != -1) {
                        y = k;
                        x = check;
                    }
                }

                isVisited[y][x] = true;

                if (check_row(y, isVisited)) bingo_cnt++;
                if (check_col(x, isVisited)) bingo_cnt++;
                if (x + y == 4) {
                    if (check_left(y, x, isVisited)) bingo_cnt++;
                }

                if (x == y) {
                    if (check_right(y, x, isVisited)) bingo_cnt++;
                }


                if(bingo_cnt >= 3) {
                    System.out.print(cnt);
                    System.exit(0);
                }
            }
        }
    }

    public static boolean check_row(int y, boolean[][] isVisited) {
        for (int i = 0; i < 5; i++) {
            if (isVisited[y][i]) continue;
            return false;
        }
        return true;
    }

    public static boolean check_col(int x, boolean[][] isVisited) {
        for (int i = 0; i < 5; i++) {
            if (isVisited[i][x]) continue;
            return false;
        }
        return true;
    }

    public static boolean check_left(int y, int x, boolean[][] isVisited) {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (i + j != 4) continue;
                if (isVisited[i][j]) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean check_right(int y, int x, boolean[][] isVisited) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) continue;
                if (isVisited[i][j]) continue;
                return false;
            }
        }
        return true;
    }
}
