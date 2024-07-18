package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M = 0;

    static List<Point> chickenStores;
    static List<Point> houses;
    static List<Point> selectedChickenStores;
    static int answer = Integer.MAX_VALUE;

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

        chickenStores = new ArrayList<>();
        houses = new ArrayList<>();
        selectedChickenStores = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    houses.add(new Point(i, j));
                } else if (num == 2) {
                    chickenStores.add(new Point(i, j));
                }
            }
        }

        bt(0, 0);
        System.out.println(answer);
    }

    public static void bt(int start, int depth) {
        if (depth == M) {
            int chickenLenSum = 0;

            for (Point hp : houses) {
                int minChickenLen = Integer.MAX_VALUE;
                for (Point scp : selectedChickenStores) {
                    int len = chickenLen(hp, scp);
                    minChickenLen = Math.min(minChickenLen, len);
                }

                chickenLenSum += minChickenLen;
            }

            answer = Math.min(answer, chickenLenSum);
        }

        for (int i = start; i < chickenStores.size(); i++) {
            if (selectedChickenStores.contains(chickenStores.get(i))) {
                continue;
            }

            selectedChickenStores.add(chickenStores.get(i));
            bt(i + 1, depth + 1);
            selectedChickenStores.remove(chickenStores.get(i));
        }
    }

    private static int chickenLen(Point house, Point chickenStore) {
        return Math.abs(house.y - chickenStore.y) + Math.abs(house.x - chickenStore.x);
    }
}
