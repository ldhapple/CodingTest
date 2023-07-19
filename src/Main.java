import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V+1][V+1];

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j) arr[i][j] = 0;
                else arr[i][j] = INF;
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[u][v] = d;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j) continue;

                if(arr[i][j] != INF && arr[j][i] != INF){
                    min = Math.min(min, arr[i][j] + arr[j][i]);
                }
            }
        }
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.print(min);
    }
}