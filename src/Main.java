import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Problem {
        public int num;
        public int diff;

        public Problem(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Problem> treeSet = new TreeSet<>((a,b) -> {
            if (a.diff == b.diff) return a.num - b.num;
            return a.diff - b.diff;
        });
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); //문제 번호
            int L = Integer.parseInt(st.nextToken()); //난이도

            treeSet.add(new Problem(P, L));
            map.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    int diff = Integer.parseInt(st.nextToken());

                    treeSet.add(new Problem(num, diff));
                    map.put(num, diff);
                    break;

                case "recommend":
                    int checker = Integer.parseInt(st.nextToken());

                    if (checker == 1) {
                        sb.append(treeSet.last().num).append("\n");
                    } else {
                        sb.append(treeSet.first().num).append("\n");
                    }
                    break;

                case "solved":
                    int number = Integer.parseInt(st.nextToken());

                    treeSet.remove(new Problem(number, map.get(number)));
                    map.remove(number);
                    break;
            }
        }

        System.out.print(sb);
    }
}
