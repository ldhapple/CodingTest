package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Egg {
        int strength, weight;

        public Egg(int strength, int weight) {
            this.strength = strength;
            this.weight = weight;
        }
    }

    static int N;
    static Egg[] eggs;
    static boolean[] isVisited;
    static int answer = 0;
    static Egg nowEgg;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(str, weight);
        }

        bt(0, 0);

        System.out.println(answer);
    }

    static void bt(int now, int cnt) {
        if (now == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        //손에 든 계란이 깨짐 || 모든 계란이 깨짐
        if (eggs[now].strength <= 0 || cnt == N - 1) {
            bt(now + 1, cnt);
            return;
        }

        int beforeCnt = cnt;

        for (int next = 0; next < N; next++) {
            if (next == now) continue; //손에 든 계란일 경우
            if (eggs[next].strength <= 0) continue; //깨진 계란인 경우

            eggs[now].strength -= eggs[next].weight;
            eggs[next].strength -= eggs[now].weight;

            if (eggs[now].strength <= 0) cnt++;
            if (eggs[next].strength <= 0) cnt++;

            bt(now + 1, cnt);

            eggs[now].strength += eggs[next].weight;
            eggs[next].strength += eggs[now].weight;
            cnt = beforeCnt;
        }
    }
}
