package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 { //연산자 끼워넣기
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] numArr;
    static int[] calcCnt;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        calcCnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calcCnt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numArr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int number, int depth) {
        if (depth == N) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }

        for (int i = 0; i < 4; i++) {
            if (calcCnt[i] < 1) continue;

            calcCnt[i]--;

            switch (i) {
                case 0:
                    dfs(number + numArr[depth], depth + 1);
                    break;

                case 1:
                    dfs(number - numArr[depth], depth + 1);
                    break;

                case 2:
                    dfs(number * numArr[depth], depth + 1);
                    break;

                case 3:
                    dfs(number / numArr[depth], depth + 1);
                    break;
            }

            calcCnt[i]++;
        }
    }
}
