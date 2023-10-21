import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Friend {
        Friend parent = null;

        public Friend root() {
            if (parent == null) return this;
            return parent = parent.root();
        }

        public boolean isConnected(Friend o) {
            return root() == o.root();
        }

        public void merge(Friend o) {
            if (isConnected(o)) return;
            o.root().parent = this;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //학생 수
        int M = Integer.parseInt(st.nextToken()); //친구 관계 수
        int k = Integer.parseInt(st.nextToken()); //가지고 있는 금액

        st = new StringTokenizer(br.readLine());
        int[] friendCost = new int[N + 1];
        List<Friend> friendList = new ArrayList<>();
        friendList.add(new Friend());
        for (int i = 1; i <= N; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
            friendList.add(new Friend());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Friend friendA = friendList.get(Integer.parseInt(st.nextToken()));
            Friend friendB = friendList.get(Integer.parseInt(st.nextToken()));
            if (friendA.isConnected(friendB)) continue;
            friendA.merge(friendB);
        }

        Map<Friend, Integer> union = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                Friend friendA = friendList.get(i);
                Friend friendB = friendList.get(j);

                if (friendA.isConnected(friendB)) {
                    union.put(friendA.root(), union.getOrDefault(friendA.root(), 0) + 1);
                }
            }
        }

        System.out.print(union);
    }
}
