package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[] arr = {0, 2, 3, 1, 5, 8, 9, 10, 14};

        System.out.println(binarySearch(arr, 4));
    }

    public static int binarySearch(int[] arr, int targetVal) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = arr[mid];

            if (midValue == targetVal) return mid;

            if (midValue < targetVal) {
                start = mid + 1;
            } else if (midValue > targetVal) {
                end = mid - 1;
            }
        }

        return -1;
    }
}
