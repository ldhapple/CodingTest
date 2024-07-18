package sort;

public class Temp {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 2, 45, 1, 8, 0, 7, 10};

        int[] count = new int[46]; //정렬할 배열의 최댓값을 길이로 갖는 배열

        for (int i : arr) {
            count[i]++;
        }

        for (int i : count) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1]; //count 배열의 상태를 누적합 되도록.
        }

        for (int i : count) {
            System.out.print(i + " ");
        }
        System.out.println();

        //누적합으로 바뀌었기 때문에 count 배열은 오름차순 상태이다.
        //이 count 배열의 값을 하나씩 줄이며 결과 배열에 배치하면 결과 배열도 오름차순이 된다.

        int[] result = new int[arr.length];

        // {1, 5, 6, 7, 2, 45, 1, 8, 0, 7, 10}
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            count[val]--;
            result[count[val]] = val;
        }

//        for (int i = arr.length - 1; i >= 0; i--) {
//            int val = arr[i];
//            count[val]--;
//            result[count[val]] = val;
//        }

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
