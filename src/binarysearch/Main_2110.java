package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, C;
    static int[] houses;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //집의 개수
        C = Integer.parseInt(st.nextToken()); //공유기 개수

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 0;
        int end = houses[N - 1];
        int answer = Integer.MIN_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2; //공유기의 최소 거리

            int installPos = 0;
            int installCnt = 1;

            for (int i = 1; i < N; i++) {
                if (houses[i] - houses[installPos] >= mid) {
                    installPos = i; //최소 거리를 초과하는 위치라면 그 위치에 설치하겠다.
                    installCnt++;
                }
            }

            if (installCnt < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = Math.max(mid, answer);
            }
        }

        System.out.println(answer);
    }
}
