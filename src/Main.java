import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (order) {
                    case "I":
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;

                    case "D":
                        if (map.isEmpty()) continue;
                        int key = (num == -1) ? map.firstKey() : map.lastKey();

                        if (map.get(key) > 0) map.put(key, map.get(key) - 1);
                        if (map.get(key) == 0) map.remove(key);
                        break;
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
