package datastructure;

public class SeqSearch {

    static int seqSearch(int[] a, int n, int key) {
        int i = 0;
        while (true) {
            if (i == n) return -1;

            if (a[i] == key) return i;
            i++;
        }
    }

    public static void main(String[] args) {
        // 사용자로부터 배열의 길이, 각 배열의 항목을 입력받고 검색하는 코드


    }
}
