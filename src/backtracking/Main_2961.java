package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Food {
        int sourTaste, bitterTaste;

        public Food(int sourTaste, int bitterTaste) {
            this.sourTaste = sourTaste;
            this.bitterTaste = bitterTaste;
        }
    }

    static int N;
    static Food[] foods;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        foods = new Food[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            foods[i] = new Food(sour, bitter);
        }

        isVisited = new boolean[N];

        bt( 0, 0, 1, 0);

        System.out.println(answer);
    }

    static void bt(int idx, int depth, int sour, int bitter) {
        if (depth > 0) {
            answer = Math.min(answer, Math.abs(sour - bitter));
        }

        for (int i = idx; i < N; i++) {
            if (isVisited[i]) continue;

            isVisited[i] = true;
            bt(i + 1, depth + 1, sour * foods[i].sourTaste, bitter + foods[i].bitterTaste);
            isVisited[i] = false;
        }
    }
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//
//    static class Food {
//        int sour, bitter;
//
//        public Food(int sour, int bitter) {
//            this.sour = sour;
//            this.bitter = bitter;
//        }
//    }
//
//    static int N;
//    static Food[] foods;
//    static boolean[] isVisited;
//    static int answer = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws Exception {
//        N = Integer.parseInt(br.readLine());
//
//        foods = new Food[N];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        isVisited = new boolean[N];
//        bt(0);
//
//        System.out.println(answer);
//    }
//
//    static void bt(int depth) {
//        if (depth == N) {
//            answer = Math.min(answer, calcScore());
//            return;
//        }
//
//        isVisited[depth] = true;
//        bt(depth + 1);
//        isVisited[depth] = false;
//        bt(depth + 1);
//    }
//
//    static int calcScore() {
//        int sour = 1;
//        int bitter = 0;
//        for (int i = 0; i < isVisited.length; i++) {
//            if (!isVisited[i]) continue;
//            sour *= foods[i].sour;
//            bitter += foods[i].bitter;
//        }
//
//        if (sour == 1 && bitter == 0) return Integer.MAX_VALUE;
//
//        return Math.abs(sour - bitter);
//    }
//}
