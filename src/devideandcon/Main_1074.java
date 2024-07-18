package devideandcon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int answer = 0;
    static int dest_y, dest_x;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);
        dest_y = Integer.parseInt(st.nextToken());
        dest_x = Integer.parseInt(st.nextToken());

        search(0, 0, size);

        System.out.println(answer);
    }

    private static void search(int y, int x, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        if (dest_y < y + half && dest_x < x + half) {
            search(y, x, half);
        } else if (dest_y < y + half && dest_x >= x + half) {
            answer += half * half * 1;
            search(y, x + half, half);
        } else if (dest_y >= y + half && dest_x < x + half) {
            answer += half * half * 2;
            search(y + half, x, half);
        } else {
            answer += half * half * 3;
            search(y + half, x + half, half);
        }
    }
}
