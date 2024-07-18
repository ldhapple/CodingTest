package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); //조카의 수
        int N = Integer.parseInt(st.nextToken()); //과자의 수

        int[] cookieLen = new int[N];

        long max = 0;
        long min = 1;
        long mid = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(st.nextToken());

            cookieLen[i] = len;
        }

        Arrays.sort(cookieLen);

        max = cookieLen[N - 1];
        long result = 0;

        while (min <= max) {
            int cnt = 0;

            mid = (min + max) / 2;

            for (int i = 0; i < cookieLen.length; i++) {
                cnt += cookieLen[i] / mid;
            }

            if (cnt >= M) { //아이 수보다 막대 수가 많이 나온다 = 더 긴 길이로 잘라야 한다.
                if (result < mid) result = mid; //min == max일 때 mid값이 만약 cnt >= M에 충족하지 못하면 mid값은 답이될 수 없다.
                min = mid + 1;
            } else { //수보다 막대가 적다 = 더 짧은 길이로 잘라야 한다.
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
