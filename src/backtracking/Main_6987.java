package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_6987 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<int[]> vs = new ArrayList<>();
    static int[][] matchResult = new int[6][3];
    static int answer;


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                vs.add(new int[] {i, j}); //매치 조합 구성
            }
        }

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            boolean canMatch = true;

            for (int j = 0; j < 6; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    matchResult[j][k] = Integer.parseInt(st.nextToken());

                    sum += matchResult[j][k];
                }

                if (sum != 5) canMatch = false;
            }

            answer = 0;

            if (canMatch) bt(0);
            System.out.print(answer + " ");
        }
    }

    static void bt(int depth) {
        if (answer == 1) return;

        if (depth == 15) {
            answer = 1;
            return;
        }

        int team1 = vs.get(depth)[0];
        int team2 = vs.get(depth)[1];

        if (matchResult[team1][0] > 0 && matchResult[team2][2] > 0) {
            matchResult[team1][0]--;
            matchResult[team2][2]--;
            bt(depth + 1);
            matchResult[team1][0]++;
            matchResult[team2][2]++;
        }

        if (matchResult[team1][1] > 0 && matchResult[team2][1] > 0) {
            matchResult[team1][1]--;
            matchResult[team2][1]--;
            bt(depth + 1);
            matchResult[team1][1]++;
            matchResult[team2][1]++;
        }

        if (matchResult[team1][2] > 0 && matchResult[team2][0] > 0) {
            matchResult[team1][2]--;
            matchResult[team2][0]--;
            bt(depth + 1);
            matchResult[team1][2]++;
            matchResult[team2][0]++;
        }
    }
}
