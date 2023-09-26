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

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] alp_table = new int[26];

            if(K == 1){
                System.out.println("1 1");
                continue;
            }

            for (int j = 0; j < str.length(); j++) {
                alp_table[str.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < str.length(); j++) {
                if (alp_table[str.charAt(j) - 'a'] < K) {
                    continue;
                }

                int count = 1;
                for (int l = j+1; l < str.length(); l++) {
                    if (str.charAt(j) == str.charAt(l)) {
                        count++;
                    }

                    if (count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
