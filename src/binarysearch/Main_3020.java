package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, H;
    static int[] upStone, downStone;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        upStone = new int[N / 2]; //바닥으로부터의 길이
        downStone = new int[N / 2]; //천장으로부터의 길이

        for (int i = 0; i < N / 2; i++) {
            upStone[i] = Integer.parseInt(br.readLine());
            downStone[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(upStone);
        Arrays.sort(downStone);

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            int up = binarySearch(upStone, i);
            int down = binarySearch(downStone, H-i+1);

            if (min > up + down) {
                min = up + down;
                cnt = 1;
            } else if (min == up + down) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }

    public static int binarySearch(int[] stone, int height) {
        int left = 0;
        int right = N / 2;

        while (left < right) {
            int mid = (left + right) / 2;

            if (stone[mid] < height) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int breakCnt = stone.length - right;

        return breakCnt;
    }
}
