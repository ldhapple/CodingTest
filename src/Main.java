import java.awt.*;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;

    static int row_idx;
    static int col_idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(N);
        System.out.print(arr[0][0]);

    }

    public static void checkNum(int row, int col){
        ArrayList<Integer> checkSecond = new ArrayList<>();

        for(int i = row; i < row+2; i++){
            for(int j = col; j < col+2; j++){
                checkSecond.add(arr[i][j]);
            }
        }

        Collections.sort(checkSecond);
        arr[row_idx][col_idx] = checkSecond.get(2);
    }

    public static void search(int N){
        if(N == 1) return;

        row_idx = 0;
        col_idx = 0;

        for(int i = 0; i < N; i+=2){
            for(int j = 0; j < N; j+=2){
                checkNum(i,j);
                col_idx++;
            }
            row_idx++;
            col_idx = 0;
        }

        search(N/2);
    }
}