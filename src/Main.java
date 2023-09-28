import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = 0;

            switch (order) {
                case 1:
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    arr[num] = Integer.parseInt(st.nextToken());
                    break;

                case 2:
                    start = Integer.parseInt(st.nextToken()) - 1;
                    end = Integer.parseInt(st.nextToken()) - 1;
                    for (int k = start; k <= end; k++) {
                        if (arr[k] == 0) arr[k] = 1;
                        else arr[k] = 0;
                    }
                    break;

                case 3:
                    start = Integer.parseInt(st.nextToken()) - 1;
                    end = Integer.parseInt(st.nextToken()) - 1;
                    for (int k = start; k <= end; k++) {
                        if (arr[k] == 0) continue;
                        arr[k] = 0;
                    }
                    break;

                case 4:
                    start = Integer.parseInt(st.nextToken()) - 1;
                    end = Integer.parseInt(st.nextToken()) - 1;
                    for (int k = start; k <= end; k++) {
                        if (arr[k] == 1) continue;
                        arr[k] = 1;
                    }
                    break;
            }
        }

        for (int i : arr) {
            sb.append(i + " ");
        }

        System.out.print(sb);
    }
}
