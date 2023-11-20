import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 탑의 수

        Stack<int[]> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0").append(" ");
                stack.add(new int[]{i, height});
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.add(new int[]{i, height});
                        break;
                    }

                    int[] top = stack.peek();

                    if (top[1] > height) {
                        sb.append(top[0] + 1).append(" ");
                        stack.add(new int[]{i, height});
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
