import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열의 길이
        int K = Integer.parseInt(st.nextToken()); //최대 존재할 수 있는 개수

        int[] count = new int[100001];
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int start = 0;
        int end = 0;

        while (end < arr.length) {
            while (end < arr.length && count[arr[end]] < K) {
                count[arr[end]]++;
                end++;
            }

            int len = end - start;
            max = Math.max(max, len);
            count[arr[start]]--;
            start++;
        }

        System.out.print(max);
    }
}
