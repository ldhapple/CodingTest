package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2295 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //dfs로 세 수의 합을 찾는다. 그 세 수의 합을 저장하는 List를 만들고,
        //각각의 값이 arr에 있는 지 찾으면 된다. (X)

        // a + b + c = d --> a + b = d - c 활용

        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(sum);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int minus = arr[i] - arr[j];

                if (Collections.binarySearch(sum, minus) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}
