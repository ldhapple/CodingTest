package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int answer;

    static Consulting[] consultings;

    static class Consulting {
        public int day;
        public int cost;

        public Consulting(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        consultings = new Consulting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            consultings[i] = new Consulting(d, c);
        }

        answer = 0;
        bt(0, 0);
        System.out.println(answer);
    }

    public static void bt(int day, int total) {
        if (day > N) {
            return;
        }

        if (day == N) {
            answer = Math.max(answer, total);
            return;
        }

        bt(day + consultings[day].day, total + consultings[day].cost); //그 날의 일을 선택한 경우 cost를 추가하고 그 일이 끝나는 날로 넘어감
        bt(day + 1, total); //그 날의 일을 선택하지 않는 경우, 다음 일로 넘어감
    }
}
