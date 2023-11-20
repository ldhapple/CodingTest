import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Deque<Integer> deque;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int order = Integer.parseInt(st.nextToken());
            list.add(order);
        }

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case 1:
                    one(i);
                    break;
                case 2:
                    two(i);
                    break;
                case 3:
                    three(i);
                    break;
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.print(sb);
    }

    private static void one(int i) {
        deque.offerLast(i+1);
    }

    private static void two(int i) {
        int temp = deque.pollLast();
        deque.offerLast(i+1);
        deque.offerLast(temp);
    }

    private static void three(int i) {
        deque.offerFirst(i+1);
    }
}
